package cn.tedu.sortProfit;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortProfitReducer extends Reducer<Profit, NullWritable, Profit,NullWritable> {
    @Override
    protected void reduce(Profit key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key,NullWritable.get());
    }
}
