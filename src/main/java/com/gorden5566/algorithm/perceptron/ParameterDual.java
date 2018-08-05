package com.gorden5566.algorithm.perceptron;

import java.util.Arrays;

/**
 * @author gorden5566
 * @date 2018/8/5
 */
public class ParameterDual {
    /**
     * 参数alpha，大小等于样本容量
     */
    private double[] alpha;

    /**
     * 参数b
     */
    private double b;

    /**
     * 构造函数
     *
     * @param m 样本容量
     * @param b
     */
    public ParameterDual(int m, double b) {
        this.alpha = new double[m];
        this.b = b;
    }


    public double[] getAlpha() {
        return alpha;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "ParameterDual{" +
            "alpha=" + Arrays.toString(alpha) +
            ", b=" + b +
            '}';
    }
}
