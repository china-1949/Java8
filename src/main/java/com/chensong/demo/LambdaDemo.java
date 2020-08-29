package com.chensong.demo;


import java.util.function.Predicate;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: LambdaDemo
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/11/3 13:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/3 13:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LambdaDemo {
    public static  void  main(String[] args){
       //使用Lambda之前
       new Thread(new Runnable() { //匿名函数
           @Override
           public void run() {
                System.out.println("run");
           }

       }).start();



        //使用Lambda表达式（可以使得匿名函数变得更加简洁）
        new Thread(()-> System.out.println("run2")).start();

        //Lambda表达式 ()->{} ,当 System.out.println(a+""+b+"c")为()里面方法的最终执行体时{}则可以省略，如下
//        (a,b,c) ->{
//            System.out.println(a+""+b+"c");
//        }
        new Thread(()->{ //含有其他方法则{}不可以省略
            System.out.println("run3");
            int x=1;
            int y=2;
        }).start();

       //====================================================
        // ()->{}
        //函数式接口（FunctionalInterface）
        //一个接口中定义了唯一抽象方法，通过@FunctionalInterface注解标识

        SayHelloService helloService = new SayHelloService() {
            @Override
            public void sayHello(String msg) {  //实现类重写sayHello方法
                System.out.println(msg);
            }
        };
        helloService.sayHello("zhiqian");

       //使用了Lambda表达式之后
        SayHelloService helloService2 =(msg) ->{
            System.out.println(msg);
        };

        //简化
        SayHelloService helloService1 =((msg) ->   System.out.println(msg));

        helloService2.sayHello("chensong");
        helloService1.sayHello("chensong2");


//==========================================================================



        new LambdaDemo().say((msg) ->{
            System.out.println(msg);
        });

        //==============================================

        //函数式接口方法
        //Predicate,Comsumer,Function,Supplier,BinaryOprator

        Predicate<Integer> predicate =i ->i>10;
        System.out.println(new LambdaDemo().demo(predicate,5));
        //接口的静态方法，接口名点静态方法 Predicate.
        //default方法子类可以直接调用或者，修改该方法predicate.
    }

    public String say(SayHelloService sayHelloService){
        sayHelloService.sayHello("test");
        return "SUCESS";
    }

    public String demo(Predicate<Integer> p , Integer num){
        if(p.test(num)){  //返回boolean类型 ，只有一个方法 默认default方法和static方法除外
            return "true";
        }
        return  "flase";
    }

}
