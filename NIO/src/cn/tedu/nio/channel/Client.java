package cn.tedu.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel sc=SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("localhost",8090));//试图去连接服务器
        //在阻塞模式下 无论是否建立连接 都会继续向下执行
        //判断连接是否建立
        while(!sc.isConnected()){
            //视图建立连接 但不一定建立成功
            //如果试图建立连接 一次没有成功可以再次连接
            //但是连接过多次依然没有成功 那说明连接是无法建立的
            //finishConnect的底层会技术进行建立连接的计数操作
            //当多次建立连接依然无法通过创建连接的话 就会扔出异常 此时需要进行处理
            sc.finishConnect();
        }
        //需要创建一个buffer进行数据的写入
        /*ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put("hello server".getBytes());*/
        ByteBuffer buffer=ByteBuffer.wrap("hello server".getBytes());//创建对象的连接 这一步操作和前面的两部的操作是一样的
        //直接通过写入一个数组进行对象的创建
        sc.write(buffer);
        //进行关流
        //读取服务器端传输的数据
        Thread.sleep(30);
        ByteBuffer dfs=ByteBuffer.allocate(1024);
        sc.read(dfs);
        dfs.flip();
        byte[] array = dfs.array();
        System.out.println(new String(array,0,dfs.limit()));
        sc.close();
    }
}
