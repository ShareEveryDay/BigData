package cn.tedu.partscore;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PartScoreMapper extends Mapper<LongWritable, Text, Text, Score> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Score s = new Score();
        s.setMonth(Integer.parseInt(arr[0]));
        s.setName(arr[1]);
        s.setScore(Integer.parseInt(arr[2]));
        context.write(new Text(s.getName()), s);

    }
}
