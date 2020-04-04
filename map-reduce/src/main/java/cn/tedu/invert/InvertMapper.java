package cn.tedu.invert;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class InvertMapper extends Mapper<LongWritable,Text,Text,Text> {
    private Text name;
    /*
    * Called once at the beginning of the task
    * setup方法---在task任务执行的时候会被调用一次
    * */
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit inputSplit = (FileSplit) context.getInputSplit();
        String name = inputSplit.getPath().getName();
        this.name=new Text(name);
    }
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] s = value.toString().split(" ");
        //["hello","nio"]
        for (String s1 : s) {
            context.write(new Text(s1),name);
        }
    }
}
