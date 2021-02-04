package com.zhang.status;

/**
 * ClassName Stop
 * Description TODO 类描述：学习线程的停止 stop
 * 1、建议线程正常停止 --> 利用次数，不建议死循环
 * 2、建议是同标志位置 --> 设置一个标志位
 * 3、不要使用stop 或者 destroy 等过时，或者 JDK 不建议使用的方法
 *
 * @author ZhangRenjie
 * Date  2021/2/3 15:25
 */
public class Stop implements Runnable {

    // 1、设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("runing : " + i++);
        }
    }
    // 2、设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        Stop stop = new Stop();
        new Thread(stop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("mian : " + i);
            // 调用 stop 方法切换标志位，让线程停止
            if (i == 900) {
                stop.stop();
                System.out.println("stop");
            }
        }
    }
}