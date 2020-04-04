package cn.tedu.authinput;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Score implements Writable {

    private int math;
    private int english;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(math);
        out.writeInt(english);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.math = in.readInt();
        this.english = in.readInt();
    }
}
