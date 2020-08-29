package com.chensong.demo;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: SayHelloService
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/3 14:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/3 14:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@FunctionalInterface
public interface SayHelloService {
    void sayHello (String msg);

    //void say(); 接口中定义一个抽象方法
}
