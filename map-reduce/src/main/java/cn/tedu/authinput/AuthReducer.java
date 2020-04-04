package cn.tedu.authinput;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AuthReducer extends Reducer<Text, Score, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Score> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Score value : values) {
            sum += value.getMath() + value.getEnglish();
        }
        context.write(key, new IntWritable(sum));
    }
}
