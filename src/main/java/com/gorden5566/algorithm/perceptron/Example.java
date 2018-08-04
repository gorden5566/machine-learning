package com.gorden5566.algorithm.perceptron;

/**
 * 训练样本
 *
 * @author gorden5566
 * @date 2018/8/4
 */
public class Example {
    /**
     * 样本点名字
     */
    private String name;

    /**
     * 输入(为便于理解，使用两个变量表示输入向量)
     */
    private double x1;
    private double x2;

    /**
     * 输出(又叫做标记，1表示正样本，-1表示负样本)
     */
    private double y;

    public Example(String name, double x1, double x2, double y) {
        this.name = name;
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Example{" +
            "name='" + name + '\'' +
            ", x1=" + x1 +
            ", x2=" + x2 +
            ", y=" + y +
            '}';
    }
}
