package cn.tedu.maxSocore;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxSocoreReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        IntWritable max=new IntWritable(0);
        /*
        * 在MapperReduce中 为了节省内存 使用的地址的复用的机制
        * key 是Bob
        * value 是参数值
        * */
       for(IntWritable val:values){
            if(val.get()>max.get()){
                //此种操作知识地址值的赋值 并没有将实际的值赋值给当前的参数
                // max = value;
                max.set(val.get());
            }
       }
       context.write(key,max);
    }
}
