package cn.tedu.multiple;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Profit implements Writable {
    private String name="";
    private int income;
    private int outcome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getOutcome() {
        return outcome;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(name);
        dataOutput.writeInt(income);
        dataOutput.writeInt(outcome);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this. name = dataInput.readUTF();
        this.income=dataInput.readInt();
        this.outcome=dataInput.readInt();
    }
}
