package leetCode.node.medium;

import base.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * leetcode 24 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * 示例：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 */
public class Leet_24_SwapNodesInPairs {

    /**
     * 递归。
     * 遍历节点到最后，当位置为奇数时(从1开始),交换当前位置和next位置的引用
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = head;
        return recursion(sentinel, 1);
    }

    private ListNode recursion(ListNode head, int index) {
        if (head == null) {
            return head;
        }
        ListNode next = recursion(head.next, index + 1);
        //从1开始，奇数位置时next节点和当前节点交换引用
        if (next != null && index % 2 == 1) {
            head.next = next.next;
            next.next = head;
            return next;
        } else if (next != null) {
            head.next = next;
        }
        return head;
    }

    public static void main(String[] args) {
        Leet_24_SwapNodesInPairs instance = new Leet_24_SwapNodesInPairs();
        ListNode head = ListNode.init(new int[]{1,2,3,4});
        System.out.println(JSON.toJSONString(instance.swapPairs(head)));
    }
}
