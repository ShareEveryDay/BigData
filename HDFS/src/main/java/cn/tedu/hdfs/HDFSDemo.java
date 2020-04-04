package cn.tedu.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSDemo {
    //下载
    @Test
    public void get() throws URISyntaxException, IOException {
        //创建一个配置类的对象
        Configuration conf=new Configuration();
        //使用hadoop的文件管理系统中的get方法来连接hdfs
        FileSystem fs = FileSystem.get(new URI("hdfs://10.42.11.229:9000"), conf);
        //
        FSDataInputStream in = fs.open(new Path("/a.txt"));
        OutputStream out=new FileOutputStream("E:\\1.txt");
        IOUtils.copyBytes(in,out,conf);
        fs.close();
        in.close();
    }
    //上传
    @Test
    public void put() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf=new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://10.42.11.229:9000"), conf, "root");
        InputStream in=new FileInputStream("E:\\1.txt");
        FSDataOutputStream outPutStream = fs.create(new Path("/2.txt"));
        outPutStream.close();
        in.close();
    }
    //删除文件或者文件夹
    @Test
    public void delete() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf=new Configuration();
        FileSystem FS=FileSystem.get(new URI("hdfs://10.42.11.229:9000"),conf,"root");
        //true 表示的是无论目录是否为空 都可以删除掉 可以进行递归删除 也可以删除指定的文件
        //false 表示的是只能删除空的文件
        FS.delete(new Path("/2.txt"),true);
        FS.close();
    }
    //创建新的文件夹
    @Test
    public void mkdir() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf=new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://10.42.11.229:9000"), conf, "root");
        boolean mkdirs = fs.mkdirs(new Path("/log"));
        System.out.println(mkdirs);
    }
    //查询指定目录下的文件
    @Test
    public void catFile() throws URISyntaxException, IOException, InterruptedException {
        Configuration conf=new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://10.42.11.229:9000"), conf, "root");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for(FileStatus fileStatuse:fileStatuses){
            System.out.println(fileStatuse);
        }
    }
}
