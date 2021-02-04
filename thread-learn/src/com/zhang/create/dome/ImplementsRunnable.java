package com.zhang.create.dome;

/**
 * ClassName ImplementsRunnable
 * Description TODO 类描述：多个线程同时操作同一对象，抢红米 K30S 至尊版，例子
 * 发现问题：多个线程同时操作一个资源情况下，西安测绘给你不安全，数据紊乱
 * @author ZhangRenjie
 * Date  2021/2/3 11:17
 */
public class ImplementsRunnable implements Runnable {

    // 票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            // 模拟网络延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了最后" + ticketNums-- + "台红米 K30S 至尊版");
        }
    }

    public static void main(String[] args) {
        ImplementsRunnable runnable = new ImplementsRunnable();
        new Thread(runnable, "小明").start();
        new Thread(runnable, "小李").start();
        new Thread(runnable, "黄牛党").start();
    }
}