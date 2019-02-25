package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

/**
 * @program: algorithm
 * @description: 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * @author: Karl Guo
 * @create: 2019-02-25 10:09
 **/
public class RemoveNthFromEnd19 {

    int val;
    RemoveNthFromEnd19 next;

    RemoveNthFromEnd19(int val) {
        this.val = val;
    }

    class Solution {
        public RemoveNthFromEnd19 removeNthFromEnd(RemoveNthFromEnd19 head, int n) {

            /**
             * 倒数第n个节点 , 就是正数的 L - n + 1 个节点 .
             * 先遍历一遍找出链表的总长度L , 再移除第 L - n + 1 个节点
             * 如果删除的是头结点 , 返回第二个节点 , 所以需要用一个哑结点作为链表头部
             * 考虑极端情况链表只有一个节点 , 直接返回null , 都可以用哑结点实现
             */
            RemoveNthFromEnd19 dummy = new RemoveNthFromEnd19(0);
            dummy.next = head;
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            int index = length - n;
            RemoveNthFromEnd19 first = dummy;
            while (index > 0) {
                index--;
                first = first.next;
            }
            first.next = first.next.next;
            return dummy.next;
        }
    }

}
