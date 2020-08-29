package com.chensong.demo;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: Person
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/26 23:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/26 23:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Person  implements Comparable<Person>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compare (Person p1,Person p2){
        return  p1.getName().compareTo(p2.getName());
    }

    @Override
    public int compareTo(Person o) {
        return o.getName().compareTo(this.getName());
    }
}
