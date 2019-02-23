package com.guoguo.datastructureandalgorithm.algorithm.leetCode;

/**
 * @program: algorithm
 * @description: 删除链表中的节点
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * @author: Karl Guo
 * @create: 2019-02-23 10:59
 **/


public class DeleteNode237 {
    int val;
    DeleteNode237 next;

    DeleteNode237(int x) {
        val = x;
    }

    class Solution {
        public void deleteNode(DeleteNode237 node) {
            // 传入的就是要删除的结点，就直接对他进行操作 , 将后一个节点的属性赋值给它。
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }


}
