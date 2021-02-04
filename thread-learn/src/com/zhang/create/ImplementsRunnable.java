package com.zhang.create;

/**
 * ClassName ImplementsRunnable
 * Description TODO 类描述：创建线程方式而：实现 Runnable，重写run方法，执行线程需要丢入 Runnable 接口实现方法，调用 start 方法
 *
 * @author ZhangRenjie
 * Date  2021/2/3 10:32
 */
public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("start : " + i);
        }
    }

    public static void main(String[] args) {

        // 创建 Runnable 接口实现对象
        ImplementsRunnable runnable = new ImplementsRunnable();

        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(runnable).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("main : " + i);
        }
    }
}