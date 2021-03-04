package leetCode.node;

import base.ListNode;

/**
 * leetcode 206 反转链表
 *
 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Leet_206_ReverseList {

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归解法
//        ListNode node = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return node;

        //迭代解法.
        /**
         * 将当前节点的next指针指向前一个节点，由于节点没有引用前一个节点，因此必须事先存储其前一个节点，
         * 在更改节点引用之前，还需要存储后一个节点。最后返回新的头引用。
         */
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode temp = ListNode.init(a);
        Leet_206_ReverseList instance = new Leet_206_ReverseList();
        ListNode.print(instance.reverseList(temp));
    }
}
