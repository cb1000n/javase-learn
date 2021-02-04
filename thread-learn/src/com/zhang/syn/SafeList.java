package com.zhang.syn;

import java.util.ArrayList;

/**
 * ClassName UnsafeList
 * Description TODO 类描述：线程不安全的集合
 *
 * @author ZhangRenjie
 * Date  2021/2/3 20:09
 */
public class SafeList {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                strings.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(strings.size());
    }
}