package com.zhang;

/**
 * ClassName LambdaEvolution4
 * Description TODO 类描述：lambdam 演化过程 2.把实现类挪到调用类里边。
 *
 * @author ZhangRenjie
 * Date  2021/2/3 14:48
 */
public class LambdaEvolution5 {


    public static void main(String[] args) {
        // 2、lambda 简化，有参数的时候，也可以不写参数类型
        ILambda5 lambda = () -> {
                System.out.println("lambda");
        };
    }
}

// 1、定义一个函数式接口（只有一个抽象方法的接口）
interface ILambda5 {
    void lambda();
}

