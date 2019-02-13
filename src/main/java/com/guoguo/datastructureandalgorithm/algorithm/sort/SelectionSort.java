package com.guoguo.datastructureandalgorithm.algorithm.sort;

/**
 * @program: algorithm
 * @description: 选择排序
 *
 * - 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * - 算法描述
 *   - 初始状态：无序区为R[1..n]，有序区为空；
 *   - 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录  R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 *   - n-1趟结束，数组有序化了。
 *
 * @author: Karl Guo
 * @create: 2019-02-13 11:20
 **/
public class SelectionSort {


    public static void main(String[] args) {

        int[] arrNum = {1, 9, 5, 0, 2, 11};
        arrNum = selectionSort(arrNum);


    }

    private static int[] selectionSort(int[] arrNum) {
        int temp = 0;
        for (int i = 0; i < arrNum.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrNum.length; j++) {
                if (arrNum[minIndex] > arrNum[j]) {
                    minIndex = j;
                }
            }
            temp = arrNum[i];
            arrNum[i] = arrNum[minIndex];
            arrNum[minIndex] = temp;
        }
        return null;
    }

}
