package com.zhang.better;

/**
 * ClassName Tube
 * Description TODO 类描述：管程法，生产者消费者模型 --> 利用缓冲区解决
 *
 * @author ZhangRenjie
 * Date  2021/2/4 8:38
 */
public class Tube {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}
// 生产者
class Producer extends Thread {
    SynContainer container;
    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生成了" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}
// 消费者
class Consumer extends Thread {

    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 -- >" + container.pop().id + "只鸡");
        }
    }
}
// 产品
class Chicken {
    public Chicken(int id) {
        this.id = id;
    }
    int id;
}
// 缓冲区
class SynContainer {
    // 容器
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;
    // 生产者放入商品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
            // 通知消费者消费，生产等待
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 如果没有满，就生成并放入
        chickens[count] = chicken;
        count++;
        // 可以通知消费者消费了
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop() {
        // 判断能否消费
        if (count == 0){
            // 等待生产者生成
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 如果可以消费，就消费
        count --;
        Chicken chicken = chickens[count];

        // 消费完，通知生产者
        this.notifyAll();
        return chicken;
    }
}