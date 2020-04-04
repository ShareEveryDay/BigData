package cn.tedu.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 栅栏 也是对线程进行计数 在计数归零之前会陷入阻塞状态中
         *
         */
        CyclicBarrier cb=new CyclicBarrier(5);
        new Thread(new Runner(cb)).start();
        new Thread(new Runner(cb)).start();
        new Thread(new Runner(cb)).start();
        new Thread(new Runner(cb)).start();
        new Thread(new Runner(cb)).start();

    }
}
class Runner implements Runnable{
    private CyclicBarrier cb;
    public Runner(CyclicBarrier cb){
        this.cb=cb;
    }
    @Override
    public void run() {
        //
        try {
            Thread.sleep((long) (1000*Math.random()));
            String name = Thread.currentThread().getName();
            System.out.println(name+"到了起跑线");
            //运动员到了起跑线之后 等所有的运动员到了起跑线之后 全部开始昂终点跑
            //await 会让当前的线程陷入阻塞 同时较少一个计数
            cb.await();
            System.out.println(name+"到了终点");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
