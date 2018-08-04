package com.gorden5566.algorithm.perceptron;

/**
 * 感知机参数
 *
 * @author gorden5566
 * @date 2018/8/4
 */
public class Parameter {
    /**
     * 参数w
     */
    private int w1;
    private int w2;

    /**
     * 参数b
     */
    private int b;

    public Parameter(int w1, int w2, int b) {
        this.w1 = w1;
        this.w2 = w2;
        this.b = b;
    }

    public int getW1() {
        return w1;
    }

    public void setW1(int w1) {
        this.w1 = w1;
    }

    public int getW2() {
        return w2;
    }

    public void setW2(int w2) {
        this.w2 = w2;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Parameter{" +
            "w1=" + w1 +
            ", w2=" + w2 +
            ", b=" + b +
            '}';
    }
}
