package cn.tedu.partflow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PartFlowReducer extends Reducer<Text, Flow, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Flow value : values) {
            sum += value.getFlow();
        }
        context.write(key, new IntWritable(sum));
    }
}
