package cn.tedu.socoreSort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScoreSortReducer extends Reducer<Score, NullWritable,Score,NullWritable> {
    @Override
    protected void reduce(Score key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key,NullWritable.get());
    }
}
