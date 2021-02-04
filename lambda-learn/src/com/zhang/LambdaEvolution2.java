package com.zhang;

/**
 * ClassName LambdaEvolution2
 * Description TODO 类描述：lambdam 演化过程 2.把实现类挪到调用类里边。
 *
 * @author ZhangRenjie
 * Date  2021/2/3 14:48
 */
public class LambdaEvolution2 {
    // 2、静态内部实现类
    static class ImplLambda2 implements ILambda2 {

        @Override
        public void lambda() {
            System.out.println("lambda");
        }
    }

    public static void main(String[] args) {
        ImplLambda2 implLambda = new ImplLambda2();
        implLambda.lambda();
    }
}

// 1、定义一个函数式接口（只有一个抽象方法的接口）
interface ILambda2 {
    void lambda();
}

