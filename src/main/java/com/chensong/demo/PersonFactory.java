package com.chensong.demo;

import java.util.function.Supplier;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: PersionFactory
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/26 23:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/26 23:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PersonFactory {
    private Supplier<Person> supplier;
    public PersonFactory(Supplier<Person> supplier){
        this.supplier =supplier;
    }
    public Person getPerson(){  //接受一个值返回一个值
        return  supplier.get();
    }

}
