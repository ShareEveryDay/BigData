package cn.tedu.partscore;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MonthPartitioner extends Partitioner<Text, Score> {
    public int getPartition(Text text, Score score, int numPartitions) {
        int month = score.getMonth();
        // 1 -> 0
        // 2 -> 1
        // 3 -> 2
        return month - 1;
    }
}
