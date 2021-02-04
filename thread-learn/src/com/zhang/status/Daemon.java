package com.zhang.status;

/**
 * ClassName Daemon
 * Description TODO 类描述：线程守护，测试用例：上帝守护你
 *
 * @author ZhangRenjie
 * Date  2021/2/3 16:15
 */
public class Daemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        // 默认是 false 表示是用户线程，正常的线程都是用户线程
        thread.setDaemon(true);
        // 上帝守护线程启动
        thread.start();
        // 你 用户线程启动
        new Thread(you).start();
    }
}
// 上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝守护着你");
        }
    }
}
// 你
class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 16500; i++) {
            System.out.println("you're alive!");
        }
        System.out.println("========goodbye! world!=======");
    }
}