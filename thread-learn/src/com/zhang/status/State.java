package com.zhang.status;

/**
 * ClassName State
 * Description TODO 类描述：线程状态观测
 *
 * @author ZhangRenjie
 * Date  2021/2/3 16:00
 */
public class State {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        System.out.println("------------------");
        });
        // 观察状态
        Thread.State state = thread.getState();
        // NEW
        System.out.println(state);
        // 启动后观察
        thread.start();
        state = thread.getState();
        // Run
        System.out.println(state);
        // 只要线程不终止，就一直输出状态
        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            // 更新线程状态
            state = thread.getState();
            // 输出状态
            System.out.println(state);
        }
    }
}