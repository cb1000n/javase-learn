package com.zhang;

/**
 * ClassName LambdaEvolution4
 * Description TODO 类描述：lambdam 演化过程 2.把实现类挪到调用类里边。
 *
 * @author ZhangRenjie
 * Date  2021/2/3 14:48
 */
public class LambdaEvolution4 {


    public static void main(String[] args) {
        // 2、匿名内部类，没有类的名称，必须借助接口或者父类
        ILambda4 lambda = new ILambda4() {
            @Override
            public void lambda() {
                System.out.println("lambda");
            }
        };
    }
}

// 1、定义一个函数式接口（只有一个抽象方法的接口）
interface ILambda4 {
    void lambda();
}

