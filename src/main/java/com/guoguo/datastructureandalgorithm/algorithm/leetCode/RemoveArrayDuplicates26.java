package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * @author: Karl Guo
 * @create: 2019-02-18 10:19
 **/
public class RemoveArrayDuplicates26 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 ) return 0;
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index + 1;


    }


}
