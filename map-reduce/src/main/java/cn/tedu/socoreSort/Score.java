package cn.tedu.socoreSort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements WritableComparable<Score> {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String  name=" ";
    private int score;
    //指定排序规则
    @Override
    public int compareTo(Score o) {
        return this.getScore()-o.getScore();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.name);
        dataOutput.writeInt(this.score);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.name=dataInput.readUTF();
        this.score=dataInput.readInt();
    }
}
