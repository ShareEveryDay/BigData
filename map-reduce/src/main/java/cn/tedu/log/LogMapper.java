package cn.tedu.log;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    //map端获取的数据
    // key=1，value=192.168.120.23 -- [30/Apr/2018:20:25:32 +0800] "GET /asf.avi HTTP/1.1" 304 -
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] logs = value.toString().split(" ");
        context.write(new Text(logs[0]),new IntWritable(1));
    }
}
