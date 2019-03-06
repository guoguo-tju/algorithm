package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

/**
 * @program: algorithm
 * @description: 手动实现String转int
 * <p>
 * 首先我们要先把字符拆分成单个char类型，
 * char[] chars = str.ToCharArray();
 * 然后我们再用数学计算得到最终结果。
 * 数字在字符中的索引与我们们实际数字位数是相反的，所以我们计算时先算最高位。
 * int multiple = (int)Math.Pow(10, str.Length); --> 10^str.length
 * 再依次递减倍数，所以数的总和就是我们要求得的字符的int值。
 * @author: Karl Guo
 * @create: 2019-03-06 14:08
 **/
public class String2int {

    public static void main(String[] args) {
        String num = "23112";
        int result = string2int(num);
        System.out.println(result);
    }

    private static int string2int(String num) {
        char[] chars = num.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result += (chars[i] - 48) * Math.pow(10 , chars.length - 1 - i);
        }
        return result;
    }


}
