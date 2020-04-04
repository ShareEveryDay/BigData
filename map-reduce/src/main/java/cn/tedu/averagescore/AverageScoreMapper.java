package cn.tedu.averagescore;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AverageScoreMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Bob 90
        // 需要从这一行数据中将人名和分数拆分出来
        String[] arr = value.toString().split(" ");
        context.write(new Text(arr[0]), new IntWritable(Integer.parseInt(arr[1])));
    }
}
