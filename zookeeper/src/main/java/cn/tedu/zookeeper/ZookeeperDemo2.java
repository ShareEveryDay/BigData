package cn.tedu.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo2 {
    private ZooKeeper zk;
    private CountDownLatch cdl=new CountDownLatch(1);
    @Before
    public void count(){
        try {
            zk=new ZooKeeper("10.42.11.229:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                        System.out.println("节点连接成功--");
                    }
                    //如果连接成功的话 就停 止递减
                        cdl.countDown();
                }
            });
            //如果连接不成功的话 需要await 来实现等待的连接
            cdl.await();
            System.out.println("finish---");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //监控节点的数据是否变化
    @Test
    public void nodeDataChanged() throws KeeperException, InterruptedException {
        zk.getData("/log", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType()==Event.EventType.NodeDataChanged){
                    System.out.println("节点的数据被修改");
                }
                cdl.countDown();
            }
        },null);
        cdl.await();
    }
    //监控子节点的数据变化
    @Test
    public void nodeChildChanged() throws KeeperException, InterruptedException {
        zk.getData("/log", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType()==Event.EventType.NodeChildrenChanged){
                    System.out.println("子节点的数据被修改了");
                }
                    cdl.countDown();
            }
        },null);
        cdl.await();
    }
    //监控节点的增删情况
    public void nodeChanged() throws KeeperException, InterruptedException {
        zk.getData("/", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType()==Event.EventType.NodeCreated){
                    System.out.println("节点的数据被创建了");
                }else if(watchedEvent.getType()==Event.EventType.NodeDeleted){
                    System.out.println("节点的数据被删除了");
                }
                    cdl.countDown();
            }
        },null);
        cdl.await();
    }
}
