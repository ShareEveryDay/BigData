package cn.tedu.partflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PartFlowMapper extends Mapper<LongWritable, Text, Text, Flow> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        Flow f = new Flow();
        f.setPhone(arr[0]);
        f.setAddr(arr[1]);
        f.setName(arr[2]);
        f.setFlow(Integer.parseInt(arr[3]));
        context.write(new Text(f.getName()), f);
    }
}
