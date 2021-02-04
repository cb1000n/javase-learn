package com.zhang.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ClassName ImplementsCallable
 * Description TODO 类描述：创建线程方式三：实现 callble 接口，非常不推荐
 *
 * @author ZhangRenjie
 * Date  2021/2/3 11:57
 */
public class ImplementsCallable implements Callable<Boolean> {

    @Override
    public Boolean call() {
        for (int i = 0; i < 20; i++) {
            System.out.println("call : " + i);
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ImplementsCallable callable = new ImplementsCallable();
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        // 提交执行
        Future<Boolean> r = ser.submit(callable);
        // 获取结果
        boolean res = r.get();
        // 关闭服务
        ser.shutdownNow();

        for (int i = 0; i < 200; i++) {
            System.out.println("mian : " + i);
        }
    }
}