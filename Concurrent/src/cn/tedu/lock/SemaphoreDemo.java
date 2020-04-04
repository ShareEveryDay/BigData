package cn.tedu.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        /**
         * 信号量 线程获取信号量之后执行代码 当信号量减为0之后后来的线程就可以执行了
         *
         */
        Semaphore s=new Semaphore(5);
        for (int i = 0; i < 9; i++) {
            new Thread(new Eater(s)).start();
        }
        /*CountDownLatch s=new CountDownLatch(5);
        for (int i = 0; i < 9; i++) {
            new Thread(new Eater(s)).start();
        }*/
    }
}
class Eater implements Runnable{


    private Semaphore a;

        public Eater(Semaphore a) {
            this.a = a;
        }
    /*private CountDownLatch a;
    public Eater(CountDownLatch a) {
        this.a = a;
    }*/


    @Override
    public void run() {
        //当占用一张桌子之后 可以使用的桌子（信号）应该是少一个
        try {
            //占用一个信号
            a.acquire();
            //a.countDown();
            System.out.println("来了一波客人，占用了一张桌子");
            //模拟用餐 延时
            Thread.sleep((long) (1000*Math.random()));
            System.out.println("用餐完毕 现在空出来了一张桌子");
            //最后执行完成之后来释放这个资源
            a.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
