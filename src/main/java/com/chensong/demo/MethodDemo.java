package com.chensong.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: MethodDemo
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/27 0:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/27 0:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MethodDemo {
    public static void main(String[] args) { //psvm
        //类的构造方法应用
        PersonFactory factory = new PersonFactory(Person::new);
        Person person = factory.getPerson();
        //静态方法应用
        Person p1 = factory.getPerson();
        Person p2 = factory.getPerson();
        Person p3 = factory.getPerson();
        List<Person> personList =new ArrayList<>();
        p1.setName("dsfds");
        personList.add(p1);
        p1.setName("sdfsd");
        personList.add(p2);
        p1.setName("gdfghr");
        personList.add(p3);
        //静态方法应用
        personList.sort(MethodDemo::defineCompare);
        //特定对象的实例方法应用
        personList.sort(p1::compare);
        //特定类型的任意对象的实例方法应用
        personList.sort(Person::compareTo);
    }
    private  static  int defineCompare(Person p1,Person p2){
        return  p1.getName().compareTo(p2.getName());
    }

}
