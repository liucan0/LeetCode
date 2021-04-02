package leetCode.node.medium;

import base.ListNode;

/**
 * leetcode 2 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Leet_2_AddTwoNumber {

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode prev1 = l1, prev2 = l2;
        return getAddResult(l1, l2, 0);
    }

    private ListNode getAddResult(ListNode l1, ListNode l2, int pop) {
        if((l1 == null || l2 == null) && pop == 0) {
            return l1 == null ? l2 : l1;
        }
        int val = 0;
        if (l1 != null) {
            val += l1.val;
        }
        if (l2 != null) {
            val += l2.val;
        }
        val += pop;
        ListNode node = new ListNode(val % 10);
        node.next = getAddResult(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
        return node;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.init(new int[]{9,9,9,9,9,9,9});
        ListNode b = ListNode.init(new int[]{9,9,9,9});
        Leet_2_AddTwoNumber instance = new Leet_2_AddTwoNumber();
        ListNode result = instance.addTwoNumber(a, b);
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val).append(",");
            result = result.next;
        }
        System.out.println(sb);
    }
}
