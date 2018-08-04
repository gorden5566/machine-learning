package com.gorden5566.algorithm.perceptron;

import java.util.ArrayList;
import java.util.List;

/**
 * 感知机算法原始形式demo
 *
 * 正样本(3,3)和(4,3)
 * 负样本(1,1)
 *
 * @author gorden5566
 * @date 2018/8/4
 */
public class Perceptron {
    public static void main(String[] args) {
        // 训练样本初始化
        List<Example> trainingSet = getTrainingSet();

        // 参数初始化
        Parameter parameter = new Parameter(0, 0, 0);

        // 学习率
        int eta = 1;

        int times = 0;
        for (int i = 0; i < 100; i++) {
            // 是否有误分类
            boolean hasMisClassification = false;
            for (Example example : trainingSet) {
                // 误分类时更新参数
                if (calcDistance(example, parameter) <= 0) {
                    times++;
                    hasMisClassification = true;
                    // 输出样本和参数
                    System.out.println("第" + times + "次更新：" + example + ", " + parameter);
                    updateParameters(example, parameter, eta);
                    System.out.println("第" + times + "次更新后：" + parameter);
                }
            }

            // 全部分类正确，退出循环
            if (!hasMisClassification) {
                break;
            }
        }

        System.out.println("训练结果：" + parameter);
    }

    /**
     * 计算距离(其实就是SVM的函数间隔)
     *
     * 公式：y(wx+b)
     *
     * distance <= 0, 则分类结果错误
     * distance > 0, 则分类结果正确
     *
     * @param example
     * @param parameter
     * @return
     */
    private static int calcDistance(Example example, Parameter parameter) {
        // 计算wx(向量内积)
        int wx = parameter.getW1() * example.getX1() + parameter.getW2() * example.getX2();
        int distance = example.getY() * (wx + parameter.getB());
        return distance;
    }

    /**
     * 更新参数
     *
     * @param example
     * @param parameter
     * @param eta
     */
    private static void updateParameters(Example example, Parameter parameter, int eta) {
        // wi = wi + eta * y * xi
        int w1 = parameter.getW1() + eta * example.getY() * example.getX1();
        int w2 = parameter.getW2() + eta * example.getY() * example.getX2();
        parameter.setW1(w1);
        parameter.setW2(w2);

        // b = b + eta * y
        parameter.setB(parameter.getB() + eta * example.getY());
    }

    /**
     * 获取训练样本
     *
     * @return
     */
    private static List<Example> getTrainingSet() {
        List<Example> trainingSet = new ArrayList<>();
        Example example1 = new Example(3, 3, 1);
        Example example2 = new Example(4, 3, 1);
        Example example3 = new Example(1, 1, -1);
        trainingSet.add(example1);
        trainingSet.add(example2);
        trainingSet.add(example3);

        return trainingSet;
    }
}
