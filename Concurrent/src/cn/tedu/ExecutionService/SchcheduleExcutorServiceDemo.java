package cn.tedu.ExecutionService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchcheduleExcutorServiceDemo {
    public static void main(String[] args) {
        /**
         * 创建一个定时调度执行服务器
         * 实现了一个定时的效果
         */
        ScheduledExecutorService ses= Executors.newScheduledThreadPool(5);
        /**
         * 实现了延时执行的效果 但是线程只会执行一次
         */
        //ses.schedule(new ScheduleThread(),5, TimeUnit.SECONDS);
        /**
         * 线程定时重复执行 按照间隔时间来执行 哪个时间的间隔大就按照哪个间隔来执行
         * 如果线程的执行时间超过了间隔的时间 就按照线程的执行时间来调整间隔的事件
         * 如果线程的执行时间小于间隔的执行时间 就会按照间隔的事件来计算线程的执行时间
         */
        ses.scheduleAtFixedRate(new ScheduleThread(),0,5,TimeUnit.SECONDS);
        /**
         * 线程重复执行 按照间隔+线程的执行时间
         * 此处线程的执行的时间会按照设置的间隔的时间和线程的执行的时间的累计的和来计算线程的执行的时间
         * 两个方法之间是存在的区别的
         */
        ses.scheduleWithFixedDelay(new ScheduleThread(),0,5,TimeUnit.SECONDS);

    }

}
 class ScheduleThread implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("i am running...");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
