package cn.tedu.serialflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SerialFlowMapper extends Mapper<LongWritable, Text, Text, Flow> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 13877779999 bj zs 2145
        // 需要先将各项属性拆分出来
        String[] arr = value.toString().split(" ");
        Flow f = new Flow();
        f.setPhone(arr[0]);
        f.setAddr(arr[1]);
        f.setName(arr[2]);
        f.setFlow(Integer.parseInt(arr[3]));
        context.write(new Text(f.getName()), f);

    }
}
