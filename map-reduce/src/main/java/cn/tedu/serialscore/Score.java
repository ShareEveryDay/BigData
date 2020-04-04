package cn.tedu.serialscore;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {

    private String name = "";
    private int score1;
    private int score2;
    private int score3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeInt(this.score1);
        out.writeInt(this.score2);
        out.writeInt(this.score3);
    }

    public void readFields(DataInput in) throws IOException {
        this.name = in.readUTF();
        this.score1 = in.readInt();
        this.score2 = in.readInt();
        this.score3 = in.readInt();
    }
}
