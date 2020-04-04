package cn.tedu.averagescore;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.DecimalFormat;

public class AverageScoreReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        double sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        double avg = sum / 3;
        // 需要限定数字位数
        DecimalFormat df = new DecimalFormat("00.00");
        avg = Double.parseDouble(df.format(avg));
        context.write(key, new DoubleWritable(avg));
    }
}
