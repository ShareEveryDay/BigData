package cn.tedu.join;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

// 求每一天挣了多少钱
public class JoinMapper extends Mapper<LongWritable, Text, Text, Order> {

    private Map<String, Order> map = new HashMap<>();

    // 在处理order.txt之前，需要先处理product.txt文件
    // order.txt是放在map方法中处理
    // 所以product.txt的处理应该在map方法之前 -> setup
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 需要在这个方法中先处理product.txt
        // 获取文件地址
        URI file = context.getCacheFiles()[0];
        // 连接HDFS
        FileSystem fs = FileSystem.get(file, context.getConfiguration());
        // 获取输入流
        InputStream in = fs.open(new Path(file.toString()));
        // 获取到的是子节点，但是要处理的文件是字符文件
        // 并且文件中的内容是一行一条数据
        // 可以考虑将字节流来封装成一个字符流，最好能股按行读取
        // LineReader -> Text
        // BufferedReader -> String
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            // 1 chuizi 3999
            String[] arr = line.split(" ");
            Order o = new Order();
            o.setProId(arr[0]);
            o.setName(arr[1]);
            o.setPrice(Double.parseDouble(arr[2]));
            map.put(o.getProId(), o);
        }
        reader.close();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 处理order.txt
        // 1001 20170710 4 2
        String[] arr = value.toString().split(" ");
        Order o = new Order();
        o.setOrderId(arr[0]);
        o.setDate(arr[1]);
        o.setProId(arr[2]);
        o.setNum(Integer.parseInt(arr[3]));
        o.setName(map.get(o.getProId()).getName());
        o.setPrice(map.get(o.getProId()).getPrice());
        context.write(new Text(o.getDate()), o);
    }
}
