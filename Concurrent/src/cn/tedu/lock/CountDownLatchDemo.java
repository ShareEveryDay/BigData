package cn.tedu.lock;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 闭锁 也叫线程递减锁
         */
        CountDownLatch cdl=new CountDownLatch(7);
        new Thread(new Teacher(cdl)).start();
        new Thread(new Teacher(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        cdl.await();
        System.out.println("开始考试");

    }
}
class Teacher implements Runnable{
    private CountDownLatch cdl;
    public Teacher(CountDownLatch cdl) {
        this.cdl = cdl;
    }
    @Override
    public void run() {
        try {
            //模拟每一个人到达考场的时间不同
            Thread.sleep((long) (1000*Math.random()));
            System.out.println("考官到达考场");
            //减少线程的计数
            cdl.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Student implements Runnable{
    public Student(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    private CountDownLatch cdl;
    @Override
    public void run() {
        try {
            Thread.sleep((long) (1000*Math.random()));
            System.out.println("考生到考场");
            cdl.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}