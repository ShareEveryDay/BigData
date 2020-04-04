package cn.tedu.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class AuthFunction extends UDF {
    //必须要去覆盖evaluate方法
    public int evaluate(String str){
        str =str.replaceAll("\\d"," ");
        return Integer.parseInt(str);
    }
}
