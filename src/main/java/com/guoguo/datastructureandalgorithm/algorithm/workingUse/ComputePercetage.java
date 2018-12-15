package com.guoguo.datastructureandalgorithm.algorithm.workingUse;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @program: algorithm
 * @description:
 *
 *     java计算百分比
 *
 * @author: Karl Guo
 * @create: 2018-10-24 10:48
 **/
public class ComputePercetage {


    public static void main(String[] args) {

        int num = 99;
        int total = 111;

        System.out.println(getPercetage(num , total));
    }


    /**
     * 计算百分比
     * @param num
     * @param total
     * @return
     */
    private static String getPercetage(int num , int total) {

        //加0,表示着小数点
        DecimalFormat decimalFormat = new DecimalFormat("0%");
        //可以设置精确几位的小数
        decimalFormat.setMaximumFractionDigits(1);
        //模式  例如四舍五入
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        double percetage = (num * 1.0 ) / (total * 1.0);

        return decimalFormat.format(percetage);
    }


}
