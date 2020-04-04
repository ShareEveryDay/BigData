package cn.tedu.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        //获取服务器端的通道
        ServerSocketChannel ssc=ServerSocketChannel.open();
        //绑定一个连接端口
        ssc.bind(new InetSocketAddress(8070));
        //将通道设置为非阻塞
        ssc.configureBlocking(false);
        //开启一个选择器
        Selector sele=Selector.open();
        //需要将通道注册在选择器上面
        //第一个参数表示要让注册的选择器
        //第二个参数要监听的事件 表示了一个通道对象和一个选择器对象之间的注册的关系
        ssc.register(sele, SelectionKey.OP_ACCEPT);
        //用一个while表示服务器启动之后不停止
        while(true){
            //如果客户端目前是一直开启的 那么就会有大量的客户涌入进来
            //涌入的大量的客户有的是有用的连接 有的是没用的连接
            //那么久需要进行选择 选择出有用的连接
            sele.select();
            //这些连接对应的Kenneth发生的事件 accept read write
            //获取这次连接所对应的事件
            Set<SelectionKey> keys = sele.selectedKeys();
            //获取迭代器对象
            Iterator<SelectionKey> iterator = keys.iterator();
            //遍历集合，针对不同的事件来进行处理
            while(iterator.hasNext()){
                //获取当前的事件
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    //从事件中获取通道
                    ServerSocketChannel sscx= (ServerSocketChannel) key.channel();
                    //接受连接
                    SocketChannel sc=sscx.accept();
                    sc.configureBlocking(false);
                    //需要给sc注册读或者写事件
                    //如果后注册的事件会把之间注册时的事件给覆盖掉
                    sc.register(sele,SelectionKey.OP_WRITE+SelectionKey.OP_READ);//表示对多个事件感兴趣

                }if(key.isReadable()){
                    //从事件中获取通道
                   SocketChannel sc= (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    //需要从通道身上将可读事件移除
                    //key.interestOps() 是指
                    sc.register(sele,key.interestOps()^SelectionKey.OP_READ);

                }if(key.isWritable()){
                    //从事件中获取通道
                    SocketChannel sc = (SocketChannel) key.channel();
                    //写出数据
                    sc.write(ByteBuffer.wrap("hello client".getBytes()));
                    //从通道中移除科协事件
                    sc.register(sele,key.interestOps()^SelectionKey.OP_WRITE);
                }
                iterator.remove();
            }

        }
    }
}
