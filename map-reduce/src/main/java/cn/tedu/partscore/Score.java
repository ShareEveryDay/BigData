package cn.tedu.partscore;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {

    private int month;
    private String name = "";
    private int score;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

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

    public void write(DataOutput out) throws IOException {
        out.writeInt(this.month);
        out.writeUTF(this.name);
        out.writeInt(this.score);
    }

    public void readFields(DataInput in) throws IOException {
        this.month = in.readInt();
        this.name = in.readUTF();
        this.score = in.readInt();
    }
}
