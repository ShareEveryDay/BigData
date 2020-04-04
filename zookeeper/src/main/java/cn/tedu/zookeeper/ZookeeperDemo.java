package cn.tedu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo {
    /**
     * String ConnectString --zookeeper连接的地址
     * 连接会话的超时时间
     * Watcher watcher监控着---来监控是否连接的上 连接成功会触发该观察者 不过只会触发一次 该观察者会获取各种事件的通知
     * zookeeper的底层是按照netty来完成连接的
     *
     */
    private ZooKeeper zk;
    CountDownLatch cdl=new CountDownLatch(1);
    @Before
    public void connetct() throws IOException {

        zk=new ZooKeeper("10.42.11.229:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected)
                    System.out.println("连接成功---");
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        cdl.countDown();
        System.out.println("finish---");
    }

    /**
     * 新建节点的数据
     *PERSISTENT(0, false, false),持久化节点的数据信息
     *PERSISTENT_SEQUENTIAL(2, false, true), 自动添加顺序节点的信息并持久化节点信息
     *EPHEMERAL(1, true, false),临时的保存的节点信息 在session会话结束的时候回自动的消失
     *EPHEMERAL_SEQUENTIAL(3, true, true);自动添加顺序节点信息并临时保存
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String name=zk.create("/goods","goods server".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(name);

    }
    @Test
    //修改节点数据
    public void setNodeData() throws KeeperException, InterruptedException {
        //String path--节点的路径
        //byte Data[] 节点数据
        //int version --数据的版本--data Version 如果version的版本的值给定为-1 标示的是忽略校验 直接进行修改
        //
        Stat stat = zk.setData("/log0000000005", "log".getBytes(), 0);
        System.out.println(stat);

    }
    //获取单个数据信息
    //返回的是节点信息的描述的信息 字节数组形式的 可以进行转化来完成输出查看
    @Test
    public void getData() throws KeeperException, InterruptedException {
        Stat stat=new Stat();
        byte[] data = zk.getData("/log0000000005", null, null);
        System.out.println(new String(data));
    }
    //获取子节点
    //返回的是一个list集合的列表 可以队结果来进行遍历
    @Test
    public void getChild() throws KeeperException, InterruptedException {
        List<String> datas = zk.getChildren("/", null);
        for(String data:datas){
            System.out.println(data);
        }
    }
    //删除节点
    /**
     * 参数1 是节点的路径
     * 参数2 是节点数据的版本号 -1 表示不进行数据版本号码的检验
     * 要求节点下面没有字节点
     * 此方法执行完成之后没有返回值
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void deleNode() throws KeeperException, InterruptedException {
        zk.delete("/log0000000005",-1);
    }
    //判断节点的数据是否存在
    //存在则返回的是节点的信息 不存在则返回的是一个null值
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat data = zk.exists("/news", null);
        System.out.println(data);
    }
}
