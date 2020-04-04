package cn.tedu.ExecutionService;

import java.util.concurrent.*;

public class ExecutionServiceDemo {
    public static void main(String[] args) {
        /**
         *int corePoolSize, 第一个参数表示的是指定的核心线程的数量
         *int maximumPoolSize, 第二个参数表示的是所有线程的总数 核心线程数量+临时线数量
         *long keepAliveTime, 第三个参数表示的是临时线程存活的时间
         *TimeUnit unit,设置时间的单位
         *BlockingQueue<Runnable> workQueue, 需要自己去手动创建一个工作队列 必须是阻塞式的队列
         *RejectedExecutionHandler handler 设置一个超出数量的线程交给拒绝执行处理器 需要自己去手动创建一个并且需要去覆盖掉里面的方法
         * */
        ExecutorService es=new ThreadPoolExecutor(7, 15, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //拒绝处理时需要执行的逻辑
                System.out.println("服务拒绝执行"+r);
            }
        });
        //new Thread(new ESThread()).start();
        for(int i=0;i<20;i++){
            es.execute(new ESThread());
        }
        es.shutdown();
    }
}
class ESThread implements Runnable{

    @Override
    public void run() {
        //次线程不允许抛出异常 必须进行处理 无法进行全局的处理
        try{
            System.out.println("线程开始执行");
            Thread.sleep(3000);
            System.out.println("线程执行结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
