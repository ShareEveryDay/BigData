package cn.tedu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static int i=0;
    public static void main(String[] args) throws InterruptedException {
        //如果参数为true 表示的是公平锁
        //如果参数为false 表示的非公平锁
        Lock lock=new ReentrantLock(true);
        new Thread(new Add(lock)).start();
        new Thread(new Add(lock)).start();
        Thread.sleep(4000);
        // 主函数所在的类也是一个线程类
        // 当Add线程在进行累加的时候，主函数所在的主线程也会抢占
        // 那么就可能出现Add没有执行完累加，然后主线程就抢占打印
        // 所以主线程在启动之后需要等待上面2个线程执行完成之后才能继续打印
        System.out.println(i);//0 线程抢占的原因 使得打印线程抢占了前面的两个线程提前的处理结果
    }
}
class Add implements Runnable{
    private Lock lock;

    public Add(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        //加锁
        lock.lock();
        /*synchronized (Add.class){*/
            for (int i = 0; i < 100; i++) {
                LockDemo.i++;
            }
        /*}*/
        //执行完成之后再进行解锁
        lock.unlock();
    }
}
