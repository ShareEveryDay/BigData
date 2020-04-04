package cn.tedu.wordCount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class wordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //需要向yarn申请一个任务
        Configuration conf = new Configuration();
        Job job=Job.getInstance(conf);
        //添加相关的类 设置入口类
        job.setJarByClass(wordCountDriver.class);
        //设置mapper类
        job.setMapperClass(WordCountMapper.class);
        //设置reduce类
        job.setReducerClass(WordCountReducer.class);
        //设置mapper的输出的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        //设置reducer的输出的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //指定要处理的文件
        FileInputFormat.addInputPath(job,new Path("hdfs://10.42.11.229:9000/txt/words.txt"));
        //指定结果的输出的路径
        FileOutputFormat.setOutputPath(job,new Path("hdfs://10.42.11.229:9000/result/wordcount"));
        //提交任务
        job.waitForCompletion(true);
    }
}
