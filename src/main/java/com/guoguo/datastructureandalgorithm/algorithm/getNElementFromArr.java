package com.guoguo.datastructureandalgorithm.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 从一个数组中获取n个元素的所有组合(递归实现)
 * @author: Karl Guo
 * @create: 2018-10-12 13:50
 **/
public class getNElementFromArr {

//    private static List<List<Integer>> arrList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3};
        int[] result = new int[2] ;
        List<List<Integer>> arrList = new ArrayList<>();
        combine_increase(arr,0, result , 2 , 2 , arr.length , arrList);
        System.out.println(arrList);
    }

    /**
     *
     * @param arr 原始数组
     * @param start 遍历起始位置
     * @param result    保存索引的结果,为一个以为数组
     * @param count     count为reslut的数组的索引值,count初始=num
     * @param num       要选取的元素个数
     * @param arr_len   数组长度
     */
    public static void combine_increase(int[] arr, int start, int[] result, int count, int num, int arr_len , List<List<Integer>> arrList ){
        int i = 0;
        for (i = start; i < arr_len + 1 - count; i++){
            ArrayList<Integer> list = new ArrayList<>();
            result[count - 1] = i;
            if (count - 1 == 0){
                int j;
                for (j = num - 1; j >= 0; j--){
//                    System.out.println(arr[result[j]]);
                      list.add(arr[result[j]]);
                }
            }else {
                combine_increase(arr, i + 1, result, count - 1, num , arr_len  , arrList);
            }
            if (list.size() > 0){
                arrList.add(list);
            }
        }
    }

}
