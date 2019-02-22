package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: algorithm
 * @description: 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author: Karl Guo
 * @create: 2019-02-21 13:55
 **/
public class PlusOne66 {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] arr = plusOne(digits);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] plusOne(int[] digits) {

        /**
         *  从个位开始遍历 ,
         *  如果当前不是9的话 , 直接 + 1
         *  如果当前位是9的话 , 变为0 , 同时把flag置为1.
         *  然后下一位的值+1 , flag置为0 .
         *  当最高位是9时 , 变为0 , 同时新建一个数组首位为1 , 后面的原始将原数组复制进来 .
         */

        int flag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                flag = 0;
            } else {
                digits[i] = 0;
                flag = 1;
            }
            if(flag == 0) break;
        }
        if (flag == 1){
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            System.arraycopy(digits , 0 , newArr , 1 , digits.length);
            return newArr;
        }else {
            return digits;
        }

    }

}
