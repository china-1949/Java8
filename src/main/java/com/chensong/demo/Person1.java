package com.chensong.demo;

import java.util.Optional;

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
public class Person1 {
   private Optional<String> name;

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }
}
