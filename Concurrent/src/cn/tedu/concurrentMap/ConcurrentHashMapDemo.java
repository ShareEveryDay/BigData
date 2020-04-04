package cn.tedu.concurrentMap;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        //默认的初始的容量为16 加载的因子0.75 最大允许的桶数为1<<30个
        //可以自己去指定容量 传的值是多少 并不代表实际的容量是多少 底层还会进行大量的计算 计算完成之后的实际容量一定是2的n次方的值
        //如果指定了初始的容量为5
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>(6);
        map.put("a","class1");
        map.put("b","class1");
        map.put("c","class1");
        map.put("d","class1");
        map.put("e","class1");
        //对结果进行遍历输出
        //操作和传统的map一样
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+value);
        }

    }
}
