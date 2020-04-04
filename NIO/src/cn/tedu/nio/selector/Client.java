package cn.tedu.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc=SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8070));
        sc.write(ByteBuffer.wrap("hello server".getBytes()));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        sc.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array(),0,buffer.limit()));
        sc.close();
    }
}
