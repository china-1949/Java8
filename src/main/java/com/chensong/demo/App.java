package com.chensong.demo;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: coursepub
 * @Package: com.chensong.demo
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: chensong
 * @CreateDate: 2019/12/27 22:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/27 22:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App {
    private static  int count =0; //共享资源

    static Lock lock =new ReentrantLock(); //锁（重入锁：不会造成死锁问题的存在）

    public static void inc(){  //每次进入里面的线程不止一个
        lock.lock();//抢占锁（此时保证每次进入里面的只是一个线程）
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;//递增

        //演示是否存在死锁问题
        decr();
        lock.unlock(); //释放锁
    }

    public static  void decr(){
        lock.lock(); //只是记录锁的次数
        count--;
        lock.unlock(); //...释放的次数
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            new Thread(()->{App.inc();}).start();
        } //异步线程的执行
        Thread.sleep(3000); //主线程阻塞保护异步线程能够执行完成
        System.out.println("result:"+count);
    }
}
