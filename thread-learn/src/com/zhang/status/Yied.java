package com.zhang.status;

/**
 * ClassName Yied
 * Description TODO 类描述：线程礼让，礼让不一定成果，还得看 cpu 调度
 *
 * @author ZhangRenjie
 * Date  2021/2/3 15:47
 */
public class Yied {
    public static void main(String[] args) {
        MyYied myYied = new MyYied();
        new Thread(myYied, "A").start();
        new Thread(myYied, "B").start();
    }
}

class MyYied implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        // 礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}