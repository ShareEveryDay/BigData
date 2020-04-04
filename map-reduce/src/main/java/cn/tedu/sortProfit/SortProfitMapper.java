package cn.tedu.sortProfit;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortProfitMapper extends Mapper<LongWritable, Text,Profit, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split(" ");
        Profit p=new Profit();
        p.setMouth(Integer.parseInt(split[0]));
        p.setName(split[1]);
        p.setProfit(Integer.parseInt(split[2]));
        context.write(p,NullWritable.get());
    }
}
