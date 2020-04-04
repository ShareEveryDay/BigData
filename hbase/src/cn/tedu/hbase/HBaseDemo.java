package cn.tedu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

public class HBaseDemo {
    private Configuration conf;
    @Before
    public void init(){
        //连接zoolkeper 获取HBase的连接
        conf= HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","10.42.11.229:2181");
    }
    @Test
    public void create() throws IOException {
        //获取HBase的管理权
        HBaseAdmin admin=new HBaseAdmin(conf);
        //创建一个表描述器
        HTableDescriptor table=new HTableDescriptor(TableName.valueOf("employer"));
        //创建列描述器
        HColumnDescriptor f1=new HColumnDescriptor("basic");
        HColumnDescriptor f2=new HColumnDescriptor("info");
        //添加列簇
        table.addFamily(f1);
        table.addFamily(f2);
        //创建表
        admin.createTable(table);
        //关流
        System.out.println("表创建完成");
        admin.close();
    }
    //添加数据
    @Test
    public void putData() throws IOException {
        //连接表
        HTable table=new HTable(conf,"employer");
        //封装put对象
        //参数表示行键
        Put put=new Put("e1".getBytes());
        //需要三个参数 family--指的是行簇 qualifier value
        put.add("basic".getBytes(), "age".getBytes(), "17".getBytes());
        table.put(put);
        table.close();
    }
    //删除数据
    @Test
    public void dropData() throws IOException {
        //连接表
        HTable table=new HTable(conf,"employer");
        //封装一个delete对象
        //删除数据 此时删除的是一行数据 根据行键来删除即可
        Delete delete=new Delete("e1".getBytes());
        table.delete(delete);
        table.close();
    }
    //查找数据
    @Test
    public void getData() throws IOException {
        //连接表
        HTable table =new HTable(conf,"employer");
        //封装get对象
        Get get=new Get("e1".getBytes());
        //将查询的结果封装成result
        Result r = table.get(get);
        byte[] value = r.getValue("basic".getBytes(),"age".getBytes());
        System.out.println(new String(value));
        table.close();
    }
    //查找集合数据 进行遍历
    @Test
    public  void scanData() throws IOException {
        HTable table=new HTable(conf,"employer");
        Scan scan=new Scan();
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> iterator = scanner.iterator();
        while(iterator.hasNext()){
            byte[] value = iterator.next().getValue("basic".getBytes(), "age".getBytes());
            System.out.println(new String(value));
        }
        table.close();
    }
    //删除表
    @Test
    public void delTable() throws IOException {
        //删除表之前需要获得管理权
        HBaseAdmin admin=new HBaseAdmin(conf);
        admin.disableTable("employer");
        admin.deleteTable("employer");
        admin.close();
    }
}
