package com.gorden5566.algorithm.perceptron;

/**
 * 训练样本
 *
 * @author gorden5566
 * @date 2018/8/4
 */
public class Example {
    /**
     * 输入(为便于理解，使用两个变量表示输入向量)
     */
    private int x1;
    private int x2;

    /**
     * 输出(又叫做标记，1表示正样本，-1表示负样本)
     */
    private int y;

    public Example(int x1, int x2, int y) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Example{" +
            "x1=" + x1 +
            ", x2=" + x2 +
            ", y=" + y +
            '}';
    }
}
