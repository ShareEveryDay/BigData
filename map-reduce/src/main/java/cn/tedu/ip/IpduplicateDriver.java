package cn.tedu.ip;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class IpduplicateDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
     //向yarn申请一个任务
        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf);
        //设置入口类
        job.setJarByClass(IpduplicateDriver.class);
        job.setMapperClass(IpDuplicateMapper.class);
        job.setReducerClass(IpDuplicateReducer.class);
        //设置文件的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        //设置reduce的文件的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        //设置需要处理的文件
        FileInputFormat.addInputPath(job,new Path("hdfs://10.42.11.229:9000/txt/ip.txt"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://10.42.11.229:9000/result/ip"));
        job.waitForCompletion(true);
    }
}
