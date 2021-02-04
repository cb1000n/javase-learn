package com.zhang;

/**
 * ClassName LambdalLear
 * Description TODO 类描述：lambdam 演化过程 1.正常写法
 *
 * @author ZhangRenjie
 * Date  2021/2/3 14:48
 */
public class LambdaEvolution1 {
    public static void main(String[] args) {
        ImplLambda implLambda = new ImplLambda();
        implLambda.lambda();
    }
}

// 1、定义一个函数式接口（只有一个抽象方法的接口）
interface ILambda {
    void lambda();
}

// 2、实现类
class ImplLambda implements ILambda {

    @Override
    public void lambda() {
        System.out.println("lambda");
    }
}