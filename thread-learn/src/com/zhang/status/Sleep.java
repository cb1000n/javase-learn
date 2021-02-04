package com.zhang.status;

import com.zhang.create.dome.ImplementsRunnable;

/**
 * ClassName Sleep
 * Description TODO 类描述
 *
 * @author ZhangRenjie
 * Date  2021/2/3 15:44
 */
public class Sleep implements Runnable {
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
        Sleep runnable = new Sleep();

        new Thread(runnable, "小明").start();
        new Thread(runnable, "小李").start();
        new Thread(runnable, "黄牛党").start();
    }
}