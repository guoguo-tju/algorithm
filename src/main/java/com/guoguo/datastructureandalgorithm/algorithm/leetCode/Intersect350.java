package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author: Karl Guo
 * @create: 2019-02-20 11:18
 **/
public class Intersect350 {

    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};
        int[] arr = insertSect(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 我们可以先递增排序，这样可以利用顺序来过滤掉已经不可能出现交集的元素，再定义两个脚标变量，这两个变量都从0开始，
     * 向后遍历，如果两个数组的值相同，存下这个值，两个脚标同时加1；
     * 如果两个数组的值不同，那么值较小的数组脚标值加1，另一个脚标值等待……直到遍历完短的那个数组……
     */
    private static int[] insertSect(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] result = new int[Math.min(arr1.length, arr2.length)];
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                result[index] = arr1[index1];
                index++;
                index1++;
                index2++;
                continue;
            }
            if (arr1[index1] > arr2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOf(result , index);

    }


}
