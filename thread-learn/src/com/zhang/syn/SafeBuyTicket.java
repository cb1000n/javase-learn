package com.zhang.syn;

/**
 * ClassName UnsafeBuyTicket
 * Description TODO 类描述：模拟不安全买票，线程不安全，有负数，buy 方法添加 synchronized ，改成安全方法
 *
 * @author ZhangRenjie
 * Date  2021/2/3 16:32
 */
public class SafeBuyTicket {

    public static void main(String[] args) {
        BuyTichet2 buyTichet = new BuyTichet2();
        new Thread(buyTichet, "我").start();
        new Thread(buyTichet, "你").start();
        new Thread(buyTichet, "黄牛").start();
    }
}

class BuyTichet2 implements Runnable {

    // 票
    private int ticketNums = 10;
    // 外部停止线程标志
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                buy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // synchronized 同步方法，锁住 this
    private synchronized void buy() throws Exception {
        // 判断是否有票
        if (ticketNums <= 0) {
            return;
        }
        // 模拟延迟
        Thread.sleep(100);
        // 买票
        System.out.println(Thread.currentThread().getName() + "买到" + ticketNums--);
    }
}