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
    private double w1;
    private double w2;

    /**
     * 参数b
     */
    private double b;

    public Parameter(double w1, double w2, double b) {
        this.w1 = w1;
        this.w2 = w2;
        this.b = b;
    }

    public double getW1() {
        return w1;
    }

    public void setW1(double w1) {
        this.w1 = w1;
    }

    public double getW2() {
        return w2;
    }

    public void setW2(double w2) {
        this.w2 = w2;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
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
