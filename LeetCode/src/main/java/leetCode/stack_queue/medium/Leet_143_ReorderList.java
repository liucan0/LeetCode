package leetCode.stack_queue.medium;

import base.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 143 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Leet_143_ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Deque<ListNode> queue = new ArrayDeque<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode reorderNode = new ListNode(Integer.MAX_VALUE);
        ListNode sentinel = reorderNode;
        while (!queue.isEmpty()) {
            sentinel.next = queue.pollFirst();
            sentinel = sentinel.next;
            sentinel.next = queue.pollLast();
            sentinel = sentinel.next;
        }
        if (sentinel != null) {
            sentinel.next = null;
        }
        head = reorderNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1,2,3,4});
        Leet_143_ReorderList instance = new Leet_143_ReorderList();
        instance.reorderList(head);
        System.out.println(head);

    }
}
