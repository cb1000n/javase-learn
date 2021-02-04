package com.zhang.better;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName Pool
 * Description TODO 类描述：使用线程池
 *
 * @author ZhangRenjie
 * Date  2021/2/4 10:33
 */
public class Pool {
    public static void main(String[] args) {
        // 1 创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 2 执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        // 3 关闭链接
        service.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}