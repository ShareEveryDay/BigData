package cn.tedu.maxSocore;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxSocoreMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
    //数值是Bob  888
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split(" ");
        context.write(new Text(split[0]),new IntWritable(Integer.parseInt(split[1])));
    }
}
