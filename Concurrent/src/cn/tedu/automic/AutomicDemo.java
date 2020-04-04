package cn.tedu.automic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AutomicDemo {
    static AtomicInteger ai=new AtomicInteger(0);
    public static void main(String[] args) {
        CountDownLatch cdl =new CountDownLatch(0);
        new Thread(new Add(cdl),"A").start();
        new Thread(new Add(cdl),"B").start();
        cdl.countDown();
        System.out.println(ai);
    }
}
class Add implements Runnable{
    private CountDownLatch cdl;
    public Add(CountDownLatch cdl){
        this.cdl=cdl;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            //对外提供了一套线程安全的自增方法
            AutomicDemo.ai.getAndIncrement();
        }
        cdl.countDown();
    }
}
