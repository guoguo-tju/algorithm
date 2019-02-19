package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 * @author: Karl Guo
 * @create: 2019-02-19 10:24
 **/
public class RotateArr189 {

    public static void main(String[] args) {
        int[] arr = {-1, -100, 3, 99, 99};
        int k = 2;
        rotate(arr, k);
        aaaaa(arr);
    }

    private static boolean aaaaa(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        boolean f = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) f = true;
        }
        System.out.println(f);
        return f;

    }

    private static void rotate(int[] arr, int k) {
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = arr[arr.length - 1];
            for (int j = arr.length - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }


}
