package leetCode.node.simple;

import base.ListNode;

/**
 * leetcode 83 删除链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class Leet_83_DeleteDuplicates {

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            ListNode preNext = prev.next;
            if (preNext != null && prev.val == preNext.val) {
                prev.next = preNext.next;
            } else {
                //只有在当前节点和下一个节点不相等时，prev指针才后移
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        b.next = new ListNode(1);
        a.next = b;
        Leet_83_DeleteDuplicates instance = new Leet_83_DeleteDuplicates();
        a = instance.deleteDuplicates(a);
        System.out.println(a);
    }
}
