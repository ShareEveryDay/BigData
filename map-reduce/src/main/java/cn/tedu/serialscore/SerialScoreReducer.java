package cn.tedu.serialscore;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SerialScoreReducer extends Reducer<Text, Score, Text, DoubleWritable> {
    @Override
    protected void reduce(Text key, Iterable<Score> values, Context context) throws IOException, InterruptedException {
        double sum = 0;
        for (Score value : values) {
            sum += value.getScore1() + value.getScore2() + value.getScore3();
        }
        context.write(key, new DoubleWritable(sum / 3));
    }
}
