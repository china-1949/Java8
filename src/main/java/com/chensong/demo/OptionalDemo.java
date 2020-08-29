package com.chensong.demo;

import java.util.Optional;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: OptionalDemo
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/27 16:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/27 16:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OptionalDemo {
    public static  String getName(Person person){
        if(person == null){
            return "unknow";
        }
        return person.getName();
    }

    public static String getNameByOptional(Person person){
        return Optional.ofNullable(person).map(p->p.getName()).orElse("unknow");
    }

    public static void main(String[] args) {


        Person person =null;
        System.out.println(getNameByOptional(person));

        //创建空的对象
        Optional<Person> op =Optional.empty();
        op.map(p->p.getName()).orElse("unknow");

        //创建非空的
        Person ps=null;
      //  Optional<Person> person1 =Optional.of(ps);

        Optional<Person> person2 =Optional.ofNullable(ps);
        System.out.println(person2.isPresent());

      //==================================================
        Person1 person3 =new Person1();
        Optional<String> s = Optional.ofNullable("");
        person3.setName(s);
        person3.getName().orElse("unknoe");




    }
}
