package cn.tedu.invert;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class InvertReducer extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //通过combine之后的结果就是 hello a.txt b.txt c.txt a.txt a.txt
        //需要进行去重处理
        Set<String> s=new HashSet<>();
        for (Text value:values){
            s.add(value.toString());
        }
        //将文件名称进行拼接
        StringBuffer sb=new StringBuffer();
        for(String s1:s){
            sb.append(s1).append("\t");
        }
        context.write(key,new Text(sb.toString()));
    }
}
