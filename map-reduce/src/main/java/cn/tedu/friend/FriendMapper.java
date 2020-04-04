package cn.tedu.friend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FriendMapper extends Mapper<LongWritable, Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        /*
        * key 是行号
        * value是当前行的内容
        * */
        String[] str = value.toString().split(" ");
        //tom json
        context.write(new Text(str[0]),new Text(str[1]));
    }
}
