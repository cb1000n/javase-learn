package com.zhang;

/**
 * ClassName LambdaEvolution3
 * Description TODO 类描述：lambdam 演化过程 2.把实现类挪到调用类里边。
 *
 * @author ZhangRenjie
 * Date  2021/2/3 14:48
 */
public class LambdaEvolution3 {


    public static void main(String[] args) {

        // 2、局部内部实现类
        class ImplLambda3 implements ILambda3 {

            @Override
            public void lambda() {
                System.out.println("lambda");
            }
        }
        ImplLambda3 implLambda = new ImplLambda3();
        implLambda.lambda();
    }
}

// 1、定义一个函数式接口（只有一个抽象方法的接口）
interface ILambda3 {
    void lambda();
}

