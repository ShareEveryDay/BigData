package cn.tedu.blockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //可以指定初始的容量 也可以不指定
        //如果指定的话 就是当前设置的这个容量
        //如果没有指定的话 就是默认int类型的最大值 0x7fffffff 0表示正数 其余的位数表示全是1 容量为2的31次方-1；
        LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<>(5);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        System.out.println(queue.remove());//删除队列头部元素并返回该元素 如果队列为空时 跑出异常NoSuchElementException
        System.out.println(queue.remove("c"));//删除队列里面的指定的元素 并返回boolean值 表示是否删除成功
        System.out.println(queue.take());//队列里面移除头部元素 并返回 如果队列为空时 产生阻塞
        for(int i=0;i<5;i++){
            System.out.println(queue.poll());//移除并返回队列的头部元素 如果为空 则返回null
        }
    }
}
