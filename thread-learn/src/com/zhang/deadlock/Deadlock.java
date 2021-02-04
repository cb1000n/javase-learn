package com.zhang.deadlock;

/**
 * ClassName Deadlock
 * Description TODO 类描述：死锁，多个线程互相拥有对象需要的资源，然后都不放开资源，然后形成僵持
 *
 * @author ZhangRenjie
 * Date  2021/2/3 20:58
 */
public class Deadlock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑凉");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

// 口红
class Lipstick {

}
// 镜子
class Mirror {

}

class Makeup extends Thread {

    // 需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择
    int choice;
    // 使用化妆品的人
    String girlName;

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        // 化妆
        try {
            makeup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws Exception {
        if (choice == 0) {
            // 获得口红的锁
            synchronized (lipstick) {
                System.out.println(this.getName() + "获得口红的锁");
                Thread.sleep(1000);
                // 一秒钟后想获得镜子
                synchronized (mirror) {
                    System.out.println(this.getName() + "获得镜子的锁");
                }
            }
        } else {
            // 获得镜子的锁
            synchronized (mirror) {
                System.out.println(this.getName() + "获得镜子的锁");
                Thread.sleep(1000);
                // 一秒钟后想获得口红
                synchronized (lipstick) {
                    System.out.println(this.getName() + "获得口红的锁");
                }
            }
        }
    }
}