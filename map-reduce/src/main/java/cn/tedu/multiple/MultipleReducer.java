package cn.tedu.multiple;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MultipleReducer extends Reducer<Text,Profit,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Profit> values, Context context) throws IOException, InterruptedException {
        //tom [p]
        int total=0;
        for (Profit value : values) {
            total+=value.getIncome()-value.getOutcome();
        }
        context.write(key,new IntWritable(total));
    }
}
