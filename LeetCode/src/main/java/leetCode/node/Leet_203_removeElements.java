package leetCode.node;

import base.ListNode;

/**
 * leetcode 203 移除链表中相同元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Leet_203_removeElements {

    /**
     * 初始化哨兵节点sentinel,设置sentinel.next为head,
     * 初始化两个指针，curr指向当前节点，prev指向前继节点。
     * 当前节点curr不为null时，比较当前节点值和val,若相等则删除当前节点，即prev.next = curr.next
     * 否则前继节点prev等于当前节点curr.最后curr指针向后移动
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        /*
        哨兵节点，用于树和链表中，如伪头，伪尾，标记等，是纯功能的，通常不保存任何数据，
        主要目的是使链表标准化，如使链表永不为空，永不无头，简化插入和删除。这里哨兵节点用做伪头
         */
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,6,3,4,5,6};
        ListNode temp = ListNode.init(a);
        Leet_203_removeElements instance = new Leet_203_removeElements();
        ListNode result = instance.removeElements(temp, 6);
        System.out.println(result);
    }
}
