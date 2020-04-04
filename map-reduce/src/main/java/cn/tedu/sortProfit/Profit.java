package cn.tedu.sortProfit;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Profit implements WritableComparable<Profit> {
    private int mouth;
    private String name="";
    private int profit;

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public int compareTo(Profit o) {
        int r1=this.mouth-o.mouth;
        //月份一致的话按照利润进行排序
        if(r1==0){
            return o.profit-this.profit;
        }else {
            return r1;
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.mouth);
        dataOutput.writeUTF(this.name);
        dataOutput.writeInt(this.profit);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.mouth=dataInput.readInt();
        this.name=dataInput.readUTF();
        this.profit=dataInput.readInt();
    }

    @Override
    public String toString() {
        return "Profit{" +
                "mouth=" + mouth +
                ", name='" + name + '\'' +
                ", profit=" + profit +
                '}';
    }
}
