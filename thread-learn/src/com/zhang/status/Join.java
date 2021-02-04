package com.zhang.status;

/**
 * ClassName Join
 * Description TODO 类描述：合并线程，等待此线程执行完成后，再执行其他线程，其他线程阻塞，可以想想成插队
 *
 * @author ZhangRenjie
 * Date  2021/2/3 15:52
 */
public class Join implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Join : " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        Join join = new Join();
        Thread thread = new Thread(join);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                // 插队
                thread.join();
            }
            System.out.println("mian : " + i);
        }
    }
}