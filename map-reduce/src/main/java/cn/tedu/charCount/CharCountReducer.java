package cn.tedu.charCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// Reduce的输入来自于Map的输出
// KEYIN - 输入的键的类型
// VALUEIN - 输入的值的类型
// KEYOUT - 输出的键的类型
// VALUEOUT - 输出的值的类型
public class CharCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    // 在调用reduce方法之前，会自动的将相同的键对应的值分到一组中，然后形成一个迭代器
    // key：在当前环境下应该是单个字符
    // values：表示当前字符所对应的次数
    //mapreduce.reduce.shuffle.input.buffer.percent
    // context：环境参数。可以利用这个参数将结果写到HDFS上
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // key:a
        // values：1,1,1,1,1,1,1,1,1...
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
    }
}
