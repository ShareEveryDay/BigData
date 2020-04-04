package cn.tedu.blockingQueue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 具有优先级的阻塞式的队列
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        //队列使用的时候可以指定长度也可以不指定长度
       /* PriorityBlockingQueue<String> queue=new PriorityBlockingQueue<>();
        queue.put("t");
        queue.put("q");
        queue.put("w");
        queue.put("d");
        queue.put("e");
        queue.put("d");
        queue.put("f");
        System.out.println(queue);*///获取元素的时候 会对里面的元素进行排序
        Comparator<student> comparator=new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return o1.getScore()-o2.getScore();
            }
        };
        PriorityBlockingQueue<student> queue=new PriorityBlockingQueue<>();
        queue.put(new student("zhangsan",18,59));
        queue.put(new student("lisi",20,60));
        queue.put(new student("wangmazi",21,80));
        queue.put(new student("caoyang",14,70));
        queue.put(new student("piaoqian",16,81));
        for(int i=0;i<5;i++){
            System.out.println(queue.poll());
        }
    }
}
class student implements Comparable<student> {//实现一个类 重写比较规则
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
    //对象形式的数据不能直接通过有序的队列来进行获取 需要实现Compareable来指定相关的比较规则来实现其相关的比较的基准
    //此处需要添加一定的比较规则来实现
    //compareTo>0的话 前面和后面就要进行交换 如果是小于0的话 就不会交换
    //默认是升序 也可以将比较的结果反过来来实现降序的排序
    @Override
    public int compareTo(student o) {
        return this.age-o.age;
    }


}
