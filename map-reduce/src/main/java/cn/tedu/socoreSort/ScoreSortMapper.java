package cn.tedu.socoreSort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ScoreSortMapper extends Mapper<LongWritable, Text,Score, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Score score=new Score();
        score.setName(arr[0]);
        score.setScore(Integer.parseInt(arr[1]));
        context.write(score,NullWritable.get());
    }
}
