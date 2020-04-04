package cn.tedu.multiple;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MultipleMapper1 extends Mapper<LongWritable, Text,Text,Profit> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Profit p=new Profit();
        p.setName(arr[1]);
        p.setIncome(Integer.parseInt(arr[2]));
        p.setOutcome(Integer.parseInt(arr[3]));
        context.write(new Text(arr[1]),p);

    }
}
