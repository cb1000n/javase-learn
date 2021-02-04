package com.zhang.create;

/**
 * ClassName ExtendThread
 * Description TODO 类描述：创建线程方式一：继承 Thread，重写run方法，直接调用 start 或 run 启动线程
 * 总结：线程开启不一定立即执行，需要等待 CPU 调度
 * @author ZhangRenjie
 * Date  2021/2/3 9:33
 */
public class ExtendsThread extends Thread {
    // 创建线程方式一：继承Thread，重写run方法，调用start开启线程

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run : " + i);
        }
    }

    public static void main(String[] args) {
        // mian 线程，主线程

        // 创建一个线程对象
        ExtendsThread extendThread = new ExtendsThread();
        // 调用 start 方法开启线程，同时执行
//        createThread.start();

        // 调用 run 方法开启线程，先执行 run ，run 执行完了，再执行 main
        extendThread.run();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main : " + i);
        }
    }
}