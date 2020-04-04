package cn.tedu.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;

public class JoinDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);


        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);
        job.setJarByClass(JoinDriver.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Order.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        // 获取每一笔订单卖了多少钱，那么就需要去处理order.txt
        // 在处理order.txt的时候需要用到product.txt文件中的内容
        // 那么可以考虑将product.txt放到内存中
        URI[] files = {URI.create("hdfs://hadoop01:9000/txt/union/product.txt")};
        job.setCacheFiles(files);

        FileInputFormat.addInputPath(job,
                new Path("hdfs://hadoop01:9000/txt/union/order.txt"));
        FileOutputFormat.setOutputPath(job,
                new Path("hdfs://hadoop01:9000/result/join"));

        job.waitForCompletion(true);
    }
}
