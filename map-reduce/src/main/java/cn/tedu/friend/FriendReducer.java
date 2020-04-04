package cn.tedu.friend;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendReducer extends Reducer<Text,Text,Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //如果现在的两个人具有的是真实的关系 则用数字1表示
        //key是tom value是 真实的好友关系 rose jim smith jerry
        String name=key.toString();
        List<String> ls=new ArrayList<>();
        for (Text value : values) {
            String s = value.toString();
            ls.add(s);
            //需要对格式进行统一的调换
            if(name.compareTo(s)<0){
                context.write(new Text(name + "-" + s),new IntWritable(1));
            }else {
                context.write(new Text(s + "-" + name),new IntWritable(1));
            }
        }
        //推测好友的关系
        for(int i=0;i<ls.size()-1;i++){
            String f1=ls.get(i);
            for(int j=i+1;j<ls.size();j++){
                String f2=ls.get(j);
                if(f1.compareTo(f2)<0){
                    context.write(new Text(f1 + "-" + f2),new IntWritable(0));
                }else {
                    context.write(new Text(f2 + "-" + f1),new IntWritable(0));
                }
            }
        }
    }
}
