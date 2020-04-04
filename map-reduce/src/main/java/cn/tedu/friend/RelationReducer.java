package cn.tedu.friend;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Test;

import java.io.IOException;

public class RelationReducer extends Reducer<Text, IntWritable,Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        for (IntWritable value : values) {
            if(value.get()!=0){
                return;
            }else {
                context.write(key,NullWritable.get());
            }

        }


    }
}
