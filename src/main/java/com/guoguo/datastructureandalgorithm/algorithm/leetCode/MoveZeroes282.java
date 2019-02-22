package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author: Karl Guo
 * @create: 2019-02-22 10:45
 **/
public class MoveZeroes282 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        arr = moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] moveZeroes(int[] nums) {
        /**
         *  第一次遍历数组 , 将所有非0的m个元素一次填充到数组前m
         *  第二次遍历从m开始到数组最后一个n，全部填充0 .
         */
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


}
