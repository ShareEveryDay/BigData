package cn.tedu.blockingQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建一个阻塞式顺序队列
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(5);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        //队列已满 再次使用add去添加元素会报错
        //queue.add("f");
        //第二种添加方式 返回一个特殊值
       /* boolean f = queue.offer("f");
        System.out.println(f);//f--false*/
        //第三种添加的方式 put 阻塞式的添加 一直会阻塞
        //queue.put("f");
        //第四种是定时阻塞的
        queue.offer("f",5, TimeUnit.SECONDS);
        System.out.println(queue);
        //对应着四种获取数据的方式 remove put poll poll（带参）
        System.out.println();

    }
}
