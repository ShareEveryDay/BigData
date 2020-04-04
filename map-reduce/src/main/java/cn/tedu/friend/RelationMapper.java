package cn.tedu.friend;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class RelationMapper extends Mapper<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        context.write(new Text(split[0]),new IntWritable(Integer.parseInt(split[1])));
    }
}
