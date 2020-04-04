package cn.tedu.nio.bytebuffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        //创建一个buffer对象 不能直接通过new对象的方式进行创建 --allocate意思为分配 在创建对象的初始需要对缓冲区的对象进行初始容量的设定
        //参数表示的容量--实际上表示指定的底层字节数组的大小
        ByteBuffer buffer=ByteBuffer.allocate(10);//BufferOverflowException 容量逸出异常
        //添加数据
        //在添加数据的时候 数据的字节的大小不能超过缓冲区的大小
        buffer.put("abc".getBytes());
        buffer.put("def".getBytes());
        //底层是字节的数组 初始会通过数字0进行初始容量的占位
        System.out.println(buffer.capacity());//获取数组的容量位
        //buffer.put("hello".getBytes());
        //byte b = buffer.get();
       // System.out.println(b);//打印的结果是0 由于下标的移动 指针向后挪动到操作位 且数值为0 put或者get都会使得下标进行移动
        int position = buffer.position();
        System.out.println(position);//指针现在的操作位置是在下标为7的位置
        /*buffer.position(0);
        System.out.println(buffer.get());*///get put方法都会使操作位的位置向后移动
        //遍历缓冲区的数据
        //buffer.limit(buffer.position());
        //buffer.position(0);
        //翻转缓冲区
        buffer.flip();//等价于前面的两步操作
        //以上三个属性之间的大小关系：0 <= position <= limit <= capacity
        //while(buffer.position()<buffer.limit()){
        while(buffer.hasRemaining()){//等价于前面的一段判断体
            byte b = buffer.get();
            System.out.println(b);
        }
    }
}
