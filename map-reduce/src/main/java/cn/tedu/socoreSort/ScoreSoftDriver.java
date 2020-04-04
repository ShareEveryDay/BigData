package cn.tedu.socoreSort;

import cn.tedu.sortProfit.Profit;
import cn.tedu.sortProfit.SortKProfitDriver;
import cn.tedu.sortProfit.SortProfitMapper;
import cn.tedu.sortProfit.SortProfitReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ScoreSoftDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 需要先向YARN申请一个任务
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 设置入口类
        job.setJarByClass(ScoreSoftDriver.class);
        // 设置Mapper类
        job.setMapperClass(ScoreSortMapper.class);
        // 设置Reducer类
        job.setReducerClass(ScoreSortReducer .class);

        /*// 设置Mapper的输出类型
        job.setMapOutputKeyClass(Profit.class);
        job.setMapOutputValueClass(NullWritable.class);
*/
        // 设置Reducer的输出类型
        job.setOutputKeyClass(Profit.class);
        job.setOutputValueClass(NullWritable.class);

        // 指定要处理的文件
        FileInputFormat.addInputPath(job,
                new Path("hdfs://10.42.11.229:9000/result/maxscore2/"));
        // 指定输出路径
        // 要求输出路径在HDFS上不存在
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://10.42.11.229:9000/result/sortscore"));

        // 提交任务
        job.waitForCompletion(true);
    }

}
