package leetCode.node;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 234 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Leet_234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        List<Integer> valueList = new ArrayList<>();
        while (curr != null) {
            valueList.add(curr.val);
            curr = curr.next;
        }
        int start = 0, end = valueList.size() - 1;
        while (start < end) {
            if (valueList.get(start) != valueList.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] temp = {1, 2};
        ListNode head = ListNode.init(temp);
        Leet_234_IsPalindrome instance = new Leet_234_IsPalindrome();
        System.out.println(instance.isPalindrome(head));
    }
}
