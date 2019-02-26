package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

/**
 * @program: algorithm
 * @description: 第一个错误的版本
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例:
 * <p>
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <p>
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * <p>
 * 所以，4 是第一个错误的版本。
 * @author: Karl Guo
 * @create: 2019-02-26 10:34
 **/
public class FirstBadVersion278 {

    public static void main(String[] args) {
        int version = 0;
        boolean f = isBadVersion(version);
        int i = firstBadVersion(8);
        System.out.println(i);
    }


    public static int firstBadVersion(int n) {
        // 用过二分法用最少的次数找到version
        int left = 0;
        int right = n;
        while (true){
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            }else {
                if (isBadVersion(middle + 1)) {
                    return middle + 1;
                }else {
                    left = middle;
                }
            }
        }
    }


    private static boolean isBadVersion(int version) {
        if (version >= 6) return true;
        else return false;
    }


}
