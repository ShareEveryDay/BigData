package cn.tedu.serialflow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// 统计一个人花费的流量 --- Text,IntWritable
// 统计一个人出现过的地区 --- Text,Text
// 统计一个人拥有的手机号 -- Text,Text
public class SerialFlowReducer extends Reducer<Text, Flow, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (Flow value : values) {
            sum += value.getFlow();
        }
        context.write(key, new IntWritable(sum));
    }
}
// 统计一个人出现过的地区
// class SerialAddressReducer extends Reducer<Text,Flow, Text, Text>{}
