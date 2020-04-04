package cn.tedu.ExecutionService;

import java.util.concurrent.*;

public class ExecutionServiceDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 已经封装好的一个线程池
         * 特点：
         * 全部都是临时线程 没有核心线程
         * 临时线程的数量是int类型的最大的值 所以也可以认为是可以处理无限多的请求
         * 临时线程的存活的时间是60s
         * 大池子 小队列
         * 不适合使用的长时间执行的任务
         */
        ExecutorService es=Executors.newCachedThreadPool();
        /**
         * 全部都是核心的线程 没有临时的线程
         * 工作的队列是一个阻塞式的链式队列 这个队列没有指定容量 即默认的容量是最大值
         * 小池子 大队列
         * 适用于并发低的任务的场景 例如下载
         * 不适合使用高并发的任务的场景
         */
        ExecutorService es1=Executors.newFixedThreadPool(5);
        //执行Callable线程
        //Java将这个执行的结果进行了封装 返回的结果是一个Future对象
        //这个线程的启动方式只能通过线程池的submit的方式进行启动
        Future<String> submit = es1.submit(new CThread());
        System.out.println(submit.get());//获取这个返回值对象身上的属性
        //关闭线程池
        es1.shutdown();
    }
}
class CThread implements Callable<String>{
    @Override
    public String call() throws Exception {
        //此线程允许抛出异常
        return "success";
    }
}