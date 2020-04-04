package cn.tedu.charCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class CharCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 需要先向YARN申请一个任务
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 设置入口类
        job.setJarByClass(CharCountDriver.class);
        // 设置Mapper类
        job.setMapperClass(CharCountMapper.class);
        // 设置Reducer类
        job.setReducerClass(CharCountReducer.class);

        // 设置Mapper的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置Reducer的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 指定要处理的文件
        FileInputFormat.addInputPath(job,
                new Path("hdfs://10.42.11.229:9000/txt/characters.txt"));
        // 指定输出路径
        // 要求输出路径在HDFS上不存在
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://10.42.11.229:9000/result/charcount01"));

        // 提交任务
        job.waitForCompletion(true);
    }
}
