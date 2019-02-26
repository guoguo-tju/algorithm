package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * @author: Karl Guo
 * @create: 2019-02-26 11:55
 **/
public class MergeArr88 {


    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 0, 0, 0};
        int[] arrB = {2, 5, 6};
        merge(arrA, 3, arrB, 3);

    }

    /**
     * 使用额外空间的思路
     * 混合插入有序数组，由于两个数组都是有序的，所有只要按顺序比较大小即可。
     * 最先想到的方法是建立一个m+n大小的新数组，
     * 然后逐个从A和B数组中取出元素比较，把较小的加入新数组，
     * 然后在考虑A数组有剩余和B数组有剩余的两种情况，把剩余的放入新数组后面
     * 最后在把新数组的元素重新赋值到A数组中即可。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                newArr[k++] = nums2[j++];
            } else {
                newArr[k++] = nums1[i++];
            }
        }
        if (i != m) {
            while (i < m) {
                newArr[k++] = nums1[i++];
            }
        }
        if (j != n) {
            while (j < n) {
                newArr[k++] = nums2[j++];
            }
        }
        System.arraycopy(newArr , 0 , nums1 , 0 , newArr.length);
        System.out.println(Arrays.toString(nums1));

    }

}
