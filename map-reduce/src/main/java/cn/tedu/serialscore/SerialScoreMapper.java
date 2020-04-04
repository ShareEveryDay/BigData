package cn.tedu.serialscore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SerialScoreMapper extends Mapper<LongWritable, Text, Text, Score> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Score s = new Score();
        s.setName(arr[0]);
        s.setScore1(Integer.parseInt(arr[1]));
        s.setScore2(Integer.parseInt(arr[2]));
        s.setScore3(Integer.parseInt(arr[3]));
        context.write(new Text(s.getName()), s);
    }
}
