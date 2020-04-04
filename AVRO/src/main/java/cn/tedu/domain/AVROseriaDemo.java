package cn.tedu.domain;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AVROseriaDemo {
    @Test
    public void create(){
        //方式1 通过无参构造来创建对象
        User u1=new User();
        u1.setUsername("amy");
        u1.setAge(15);
        u1.setGender("male");
        System.out.println(u1);
        //方式二 通过有参构造来创建对象
        User u2=new User("json",18,"male");
        System.out.println(u2);
        //方式三 利用建造者模式来进行对象的创建 利用已经存在的对象在存在的对象的基础上进建对象
        User u3= User.newBuilder(u2).setUsername("tom").build();
        System.out.println(u3);
    }
    @Test
    public void serial() throws IOException {
        User u4=new User("jam",16,"male");
        User u5=new User("bob",17,"male");
        User u6=new User("anna",18,"female");
        //创建序列化流
        DatumWriter<User> dw=new SpecificDatumWriter<>(User.class);
        //创建一个文件流用于将序列化之后的数据写出到指定的文件
        DataFileWriter<User> dfw=new DataFileWriter<>(dw);

        //
        dfw.create(User.SCHEMA$,new File("E:\\a.txt"));
        dfw.append(u4);
        dfw.append(u5);
        dfw.append(u6);
        dfw.close();
    }
    @Test
    public void deserial() throws IOException {
        //创建序列化流
        DatumReader<User> dr=new SpecificDatumReader<>(User.class);
        //反序列化在设计的时候设计的是迭代器的模式 可以直接对结果进行遍历
        DataFileReader<User> dfr=new DataFileReader<User>(new File("E:\\a.txt"),dr);
        while(dfr.hasNext()){
            User u = dfr.next();
            System.out.println(u);
        }
        //数据传输完成之后需要进行管理u的操作
        dfr.close();
    }
}
