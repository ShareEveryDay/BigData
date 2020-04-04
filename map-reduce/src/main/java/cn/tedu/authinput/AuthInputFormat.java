package cn.tedu.authinput;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class AuthInputFormat extends FileInputFormat<Text, Text> {
    // 在这个方法中考虑读取过程
    @Override
    public RecordReader<Text, Text> createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        return new AuthReader();
    }
}

class AuthReader extends RecordReader<Text, Text> {

    private static final byte[] blank = new Text(" ").getBytes();
    private LineReader reader;
    private Text key;
    private Text value;

    // 初始化，在刚开始的时候调用一次
    @Override
    public void initialize(InputSplit split, TaskAttemptContext context) throws IOException {
        // 获取到要读取的路径
        FileSplit fs = (FileSplit) split;
        Path path = fs.getPath();
        // 连接HDFS
        FileSystem sys = FileSystem.get(
                URI.create(path.toString()),
                context.getConfiguration()
        );
        // 获取输入流读取文件
        InputStream in = sys.open(path);
        // 如果直接使用字节流来读取原文件，那么需要自己判断什么时候读完了三行
        // 考虑将这个字节流包装，最好包装成能够按行读取的字符流
        reader = new LineReader(in);
    }

    // 在Mapper中，调用该方法判断有没有下一个键值对
    // 需要在这个方法中判断是否还有键值对给map方法处理
    // 只需要试着去读取数据，如果读到了那么说明还有数据给map方法处理就需要返回true
    // 如果没有读到数据那么说明没有数据给map方法处理就需要返回false
    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        key = new Text();
        value = new Text();
        Text tmp = new Text();

        // 读取第一行
        // 需要传入一个Text类型的参数，会将读取到的一行数据放入这个参数中
        // 这个方法会有一个返回值，返回值表示读取到的字节个数
        if (reader.readLine(tmp) <= 0)
            // 没有读取到
            return false;
        // 如果读取到了数据，那么读取的第一行数据就是键
        key.set(tmp.toString());
        if (reader.readLine(tmp) <= 0)
            return false;
        value.set(tmp.toString());
        if (reader.readLine(tmp) <= 0)
            return false;
        value.append(blank, 0, blank.length);
        byte[] data = tmp.getBytes();
        value.append(data, 0, data.length);
        // key:tom
        // value:math 90 english 98
        return true;
    }

    // 获取键
    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    // 获取值
    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    // 获取执行的进度
    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    // 回收
    @Override
    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}
