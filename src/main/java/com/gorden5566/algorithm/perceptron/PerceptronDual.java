package com.gorden5566.algorithm.perceptron;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date 2018/8/5
 */
public class PerceptronDual {

    public static void main(String[] args) {
        // 训练样本初始化
        List<Example> trainingSet = getTrainingSet();

        // 样本大小
        int m = trainingSet.size();

        // 参数初始化
        ParameterDual parameter = new ParameterDual(m, 0);

        // 学习率
        double eta = 1;

        // 计算gram矩阵
        double[][] gram = calcGram(trainingSet);
        printGram(gram);

        int times = 0;
        for (int count = 0; count < 100; count++) {
            // 是否有误分类
            boolean hasMisClassification = false;
            for (int i = 0; i < m; i++) {
                Example example = trainingSet.get(i);

                // 误分类时更新参数
                if (calcDistance(trainingSet, parameter, i, gram) <= 0) {
                    times++;
                    hasMisClassification = true;
                    // 输出样本和参数
                    System.out.println("第" + times + "次更新：" + example + ", " + parameter);
                    updateParameters(example, parameter, i, eta);
                    System.out.println("第" + times + "次更新后：" + parameter);
                }
            }

            // 全部分类正确，退出循环
            if (!hasMisClassification) {
                break;
            }
        }

        System.out.println("训练结果：" + parameter);

        Parameter originParameter = convertToOriginParameter(parameter, trainingSet);
        System.out.println("对应原始参数：" + originParameter);

    }

    /**
     * 转换为原始参数
     *
     * @param parameterDual
     * @param trainingSet
     * @return
     */
    private static Parameter convertToOriginParameter(ParameterDual parameterDual, List<Example> trainingSet) {
        double w1 = 0;
        double w2 = 0;
        double[] alpha = parameterDual.getAlpha();
        for (int i = 0; i < alpha.length; i++) {
            Example example = trainingSet.get(i);

            // w = \sum_{i=1}^{m} \alpha_i y_i x_i  其中 w 和 x_i 均为向量
            w1 += alpha[i] * example.getX1() * example.getY();
            w2 += alpha[i] * example.getX2() * example.getY();

            // b = \sum_{i=1}^{m} \alpha_i y_i 因为已经计算出，可直接使用
        }

        Parameter originParameter = new Parameter(w1, w2, parameterDual.getB());
        return originParameter;
    }

    /**
     * 计算对偶形式的误分类数据
     *
     * 公式：y_i (\sum_{j=1}^{n} \alpha_j y_j x_j x_i + b)
     *
     * @param trainingSet
     * @param parameter
     * @param i 表示当前处理的是第几个样本
     * @param gram
     * @return
     */
    private static double calcDistance(List<Example> trainingSet, ParameterDual parameter, int i, double[][] gram) {
        //
        double sum = 0;
        for (int j = 0; j < trainingSet.size(); j++) {
            Example examplej = trainingSet.get(j);

            // 第j个样本的标记
            double yj = examplej.getY();

            double alphaj = parameter.getAlpha()[j];

            // \alpha_j y_j x_j x_i 其中 x_j x_i 直接从 gram 矩阵中获取
            sum += alphaj * yj * gram[j][i];
        }

        // 代入公式
        double result =  trainingSet.get(i).getY() * (sum + parameter.getB());

        return result;
    }

    /**
     * 更新参数
     *
     * @param example
     * @param parameter
     * @param i
     * @param eta
     */
    private static void updateParameters(Example example, ParameterDual parameter, int i, double eta) {
        double[] alpha = parameter.getAlpha();
        double b = parameter.getB();

        // \alpha_i = \alpha_i + \eta
        alpha[i] = alpha[i] + eta;

        // b = b + \eta * y_i
        parameter.setB(b + eta * example.getY());
    }

    /**
     * 打印gram矩阵
     *
     * @param gram
     */
    private static void printGram(double[][] gram) {
        System.out.println("gram matrix: ");
        for (int i = 0; i < gram.length; i++) {
            for (int j = 0; j < gram[0].length; j++) {
                System.out.print(gram[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 计算gram矩阵
     *
     * @param trainingSet
     * @return
     */
    private static double[][] calcGram(List<Example> trainingSet) {
        int m = trainingSet.size();
        double[][] gram = new double[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                Example xi = trainingSet.get(i);
                Example xj = trainingSet.get(j);
                // 内积
                gram[i][j] = xi.getX1() * xj.getX1() + xi.getX2() * xj.getX2();
            }
        }

        return gram;
    }

    /**
     * 获取训练样本
     *
     * @return
     */
    private static List<Example> getTrainingSet() {
        List<Example> trainingSet = new ArrayList<>();
        Example example1 = new Example("x1",3, 3, 1);
        Example example2 = new Example("x2",4, 3, 1);
        Example example3 = new Example("x3",1, 1, -1);
        trainingSet.add(example1);
        trainingSet.add(example2);
        trainingSet.add(example3);

        return trainingSet;
    }
}
