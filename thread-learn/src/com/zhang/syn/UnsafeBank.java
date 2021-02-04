package com.zhang.syn;

/**
 * ClassName UnsafeBank
 * Description TODO 类描述：不安全的银行
 *
 * @author ZhangRenjie
 * Date  2021/2/3 16:39
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }
}
// 账户
class Account{
    // 余额
    int money;
    // 卡号
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
// 模拟银行取钱
class Drawing extends Thread {
    // 账户
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;
        System.out.println(account.money + "余额位 : " + account.money);
        System.out.println(this.getName() + "手里的钱" + Thread.currentThread().getName());
    }
}