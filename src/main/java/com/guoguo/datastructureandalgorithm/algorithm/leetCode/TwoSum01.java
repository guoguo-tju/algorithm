package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author: Karl Guo
 * @create: 2019-02-23 10:06
 **/
public class TwoSum01 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        nums = twoSum01(nums, target);
        System.out.println(Arrays.toString(nums));

    }

    private static int[] twoSum01(int[] nums, int target) {

        // 可以用两个for循环来实现 , 但是这样时间复杂度太高为O(n^2)
        // 可以先把数组中的数据放入HashMap中 , key为数组值 , value为数组的索引
        // 用map.containsKey( target - nums[i] )来查找符合的元素 , map.get()通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 你不能重复利用这个数组中同样的元素。 所以加i !=  map.get(target - nums[i]) 条件 , 防止 6 - 3 = 3 的情况
            if (map.containsKey(target - nums[i]) & i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
