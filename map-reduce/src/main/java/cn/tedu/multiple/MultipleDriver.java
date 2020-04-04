package cn.tedu.multiple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MultipleDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf);

        job.setJarByClass(MultipleDriver.class);
        job.setReducerClass(MultipleReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Profit.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置多源输入
        MultipleInputs.addInputPath(job,new Path("hdfs://hadoop01:9000/text/profit.txt"), TextInputFormat.class,MultipleMapper1.class);
        MultipleInputs.addInputPath(job,new Path("hdfs://hadoop01:9000/txt/profit2.txt"),TextInputFormat.class,MultipleMapper2.class);
        //设置输出的路径
        FileOutputFormat.setOutputPath(job,new Path("hdfs://hadoop01:9000/result/multipleinputs"));
        //最后进行提交
        job.waitForCompletion(true);

    }
}
