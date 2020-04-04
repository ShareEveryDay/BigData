package cn.tedu.log;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LogDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //需要向yarn申请一个任务
        Configuration conf = new Configuration();
        Job job=Job.getInstance(conf);
        //添加相关的类 设置入口类
        job.setJarByClass(LogDriver.class);
        //设置mapper类
        job.setMapperClass(LogMapper.class);
        //设置reduce类
        job.setReducerClass(LogReduce.class);
        //设置相同的输出的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //指定要处理的文件
        FileInputFormat.addInputPath(job,new Path("hdfs://10.42.11.229:9000/txt/log.txt"));
        //指定结果的输出的路径
        FileOutputFormat.setOutputPath(job,new Path("hdfs://10.42.11.229:9000/result/logCount"));
        //提交任务
        job.waitForCompletion(true);
    }
}
