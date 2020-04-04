package cn.tedu.partflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AddrPartitioner extends Partitioner<Text, Flow> {
    // 指定分区
    public int getPartition(Text text, Flow flow, int numPartitions) {
        // 获取地区
        String addr = flow.getAddr();
        if (addr.equals("bj"))
            return 0;
        else if (addr.equals("sh"))
            return 1;
        else
            return 2;
    }
}
