package cn.tedu.log;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class LogReduce extends Reducer<Text, IntWritable,Text,IntWritable> {
    //reduce端收的的数据key=192.168.120.23，value=[1,1,1,1,1]
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum=0;
        for (IntWritable value : values) {
            sum+=value.get();
        }
        context.write(key,new IntWritable(sum));
    }
}
