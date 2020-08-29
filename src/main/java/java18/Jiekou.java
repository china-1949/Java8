package java18;

/**
 * @ProjectName: coursepub
 * @Package: java18
 * @ClassName: Jiekou
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/20 12:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/20 12:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface Jiekou {
    //默认方法
    default void defaultMehtod() {
        System.out.println("CommonInterface's default method　is running...");
    }

    //默认方法可以有多个
    default void anotherDefaultMehtod() {
        System.out.println("CommonInterface's second default method is running...");
    }

    static void staticMethod() {
        System.out.println("CommonInterface's static method is running...");
    }
}
