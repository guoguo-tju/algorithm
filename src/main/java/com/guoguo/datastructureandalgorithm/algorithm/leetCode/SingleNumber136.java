package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author: Karl Guo
 * @create: 2019-02-20 10:21
 **/
public class SingleNumber136 {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2 , 4 , 3};
        int i = singleNumber(arr);
        System.out.println(i);
    }

    private static int singleNumber(int[] arr) {
  /*      Arrays.sort(arr);
        int f = 0;
        if (arr[0] != arr[1] ) return arr[0];
        if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];
        for (int i = 1; i < arr.length -1 ; i++) {
            if ((arr[i - 1] != arr[i]) & (arr[i] != arr[i + 1])) {
                f = i;
            }
        }
        return arr[f];*/

        // 充分运用了异或的性质，两次异或同一个数就相当于没有异或。
        int len = arr.length;
        int result = 0;
        for(int i = 0; i < len; i++) {
            result ^= arr[i];
        }
        return result;

    }

}
