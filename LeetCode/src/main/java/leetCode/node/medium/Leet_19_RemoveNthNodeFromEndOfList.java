package leetCode.node.medium;

import base.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * leetcode 19 删除链表的倒数第n个节点
 * 给你一个链表，删除链表的倒数第n个节点，并返回链表的头结点
 * 进阶：
 * 你能尝试使用一趟扫描使用吗？
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class Leet_19_RemoveNthNodeFromEndOfList {
    /**
     * 解法1：快慢指针
     * 定义快慢两个指针，快指针先走n步，再同时移动快慢指针，快指针到达末尾时慢指针位置即为
     * 倒数第n个元素位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 解法2：递归
     */
    /*private int length = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        //哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        sentinel.next = recursion(sentinel.next, n);
        return sentinel.next;
    }

    private ListNode recursion(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        length++;
        int curr = length;//当前位置
        head.next = recursion(head.next, n);
        if (curr + n - length == 1) {
            return head.next;
        }
        return head;
    }*/

    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1,2});
        Leet_19_RemoveNthNodeFromEndOfList instance = new Leet_19_RemoveNthNodeFromEndOfList();
        System.out.println(JSON.toJSONString(instance.removeNthFromEnd(head, 2)));

    }
}
