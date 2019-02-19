package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

/**
 * @program: algorithm
 * @description: 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * <p>
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * @author: Karl Guo
 * @create: 2019-02-19 11:11
 **/
public class GuessNumber374 {

    public static void main(String[] args) {
        int n = 10;
        int pick = 3;
        int m = guessNumber(1 , n, pick);
        System.out.println(m);


    }

    private static int guessNumber(int left , int right, int pick) {
        int mid = left + (right - left) / 2;
        int guess = guess(mid, pick);
        if (guess == 0) return mid;
        if (guess == -1) return guessNumber(mid + 1 , right , pick);
        else return guessNumber(left , mid - 1 , pick);
    }

    private static int guess(int n, int pick) {
        if (n == pick) {
            return 0;
        } else if (n > pick) {
            return 1;
        } else {
            return -1;
        }

    }
}
