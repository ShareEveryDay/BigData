package cn.tedu.lock;

import java.util.concurrent.Exchanger;

public class ExchaneDemo {
    public static void main(String[] args) {
        Exchanger<String> ex=new Exchanger<>();
        new Thread(new Producer(ex)).start();
        new Thread(new Consumer(ex)).start();
    }
}
class Producer implements Runnable{
    public Producer(Exchanger<String> ex) {
        this.ex = ex;
    }

    private Exchanger<String> ex;
    @Override
    public void run() {
        String info="商品";
        try {
            String msg = ex.exchange(info);
            System.out.println("生产者收到了消费者的："+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    public Consumer(Exchanger<String> ex) {
        this.ex = ex;
    }

    private Exchanger<String> ex;

    @Override
    public void run() {
        String info="金钱";
        try {
            String msg = ex.exchange(info);
            System.out.println("消费者收到了生产者的："+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
