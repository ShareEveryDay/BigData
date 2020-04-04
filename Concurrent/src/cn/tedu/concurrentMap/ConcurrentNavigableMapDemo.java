package cn.tedu.concurrentMap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentNavigableMapDemo {
    public static void main(String[] args) {
        /**
         * 提供了用于截取子映射的方法
         * 本身就是一个接口 更多的是使用它的子类来实现  并发跳跃映射
         * 数据进行新增之后 底层会对数据进行简单的排序操作
         * 适用于查询多 增删少的情况
         * 跳跃表可以进行多层的提取 最上层的跳跃表不能少于两个
         * 是一个典型的以空间换取时间的产物
         * 跳跃变的查询的事件的复杂度是o（login）
         * */
        ConcurrentNavigableMap<String,Integer> map=new ConcurrentSkipListMap<>();
        map.put("any",1);
        map.put("tom",1);
        map.put("jason",1);
        map.put("jay",1);
        map.put("lisa",1);
        System.out.println(map);
        System.out.println();
        System.out.println(map.headMap("jason"));//从头部元素开始截取 但是不包括截取的标准的元素
        System.out.println(map.tailMap("lisa"));//向后截取 包括被截取的元素
        System.out.println(map.subMap("jason","lisa"));//从制定元素的中间开始进行截取，包括起始的位置 不包括结束的位置

    }

}
