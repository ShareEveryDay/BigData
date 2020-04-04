package cn.tedu.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels. *;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws IOException {
        //开启服务器端的通道
        ServerSocketChannel ssc=ServerSocketChannel.open();
        //绑定接受的端口进行连接
        ssc.bind(new InetSocketAddress(8090));//试图去绑定客户端
        //手动设置为非阻塞
        ssc.configureBlocking(false);
        //接收连接
        SocketChannel sc=ssc.accept();
        //因为现在设置的是非阻塞 所以无论是否接收到连接都会继续玩下执行
        //判断是否接收到了连接 如果没有接收到连接 就保持一致接收的状态
        while(sc==null){
            sc=ssc.accept();
        }
        //接收到连接 应该试图读取数据
        //需要准备一个缓冲区用于存储读取到的数据
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        sc.read(buffer);
        //需要从缓冲区中获取解析的数据
        buffer.flip();
        byte[] data = buffer.array();
        System.out.println(new String(data,0,buffer.limit()));
        //由于buffer是双向传输的 此时可以可以通过对客户端进行写入数据来实现彼此的互联
        ByteBuffer dfs=ByteBuffer.wrap("hello client".getBytes());
        sc.write(dfs);
        sc.close();
        ssc.close();
    }
}
