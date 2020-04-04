package cn.tedu.charCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
// 统计每一个字符出现的次数
// 指定Map阶段的计算逻辑
// MapReduce中要求被传输的对象必须能够被序列化
// KEYIN - 输入的键的类型。默认情况下，指的是一行的字节偏移量
// VALUEIN - 输入的值的类型。默认情况下，指的是读取的一行数据
// KEYOUT - 输出的键的类型。在当前要求中，输出的键应该是字符
// VALUEOUT - 输出的值的类型。在当前要求中，输出的值应该是数字
public class CharCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    // 在Map方法中来指定处理逻辑
    // 默认情况下，每读取一行，调用一次map方法
    // key：这一行的字节偏移量
    // value：读取到的一行数据
    // context：环境参数。可以利用这个参数将结果传输给Reduce
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // dhssadau
        // 统计这一行中每一个字符出现的次数
        // 需要先将这一行中的每一个字符拆分出来
        char[] cs = value.toString().toCharArray();
        // d:2 h:1 s:2 a:2 u:1
        // d:1 h:1 s:1 s:1 a:1 d:1 a:1 u:1
        for (char c : cs) {
            //每次读取完一行的数据就会调用一此map方法来实现键值对的创建
            context.write(new Text(c + ""), new IntWritable(1));
        }
    }
}