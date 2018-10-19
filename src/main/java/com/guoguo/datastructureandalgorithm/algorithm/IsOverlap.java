package com.guoguo.datastructureandalgorithm.algorithm;

/**
 * @program: algorithm
 * @description: 判断两个区间是否重合
 * @author: Karl Guo
 * @create: 2018-10-12 16:00
 **/
public class IsOverlap {


    public static void main(String[] args) {

        int[] arr1 = {1, 100};
        int[] arr2 = {30, 50};

        Boolean b = isOverlap(arr1, arr2);
        System.out.println(b);
    }

    private static Boolean isOverlap(int[] arr1, int[] arr2) {
        int begin = Math.max(arr1[0], arr2[0]);
        int end = Math.min(arr1[1], arr2[1]);
        int len = end - begin;
        //len > 0 说明金额的区间重合
        if (len > 0) {
            return true;
        }
        return false;
    }


}
