package leetCode.node;

import base.ListNode;

/**
 * 描述：<br>
 * 找出两个链表的第一个公共结点。
 *
 * @ClassName Offer_37_FIrstPublicNode
 * @Author liucan
 * @Date 2019/11/1 上午11:35
 * @Version 1.0
 **/
public class Offer37_Leet160_FIrstPublicNode {

	/**
	 * 双指针。遍历两个链表得到长度及长度差k，较长的链表先走k步，在同时遍历两个链表，比较公共结点。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode getFirstPublicNode(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		int fLengh = 0;
		int sLength = 0;
		ListNode first = l1;
		ListNode second = l2;
		while (first != null) {
			fLengh++;
			first = first.next;
		}
		while (second != null) {
			sLength++;
			second = second.next;
		}
		int nums = fLengh - sLength;
		first = l1;
		second = l2;
		if (nums > 0) {
			for (int i = 0; i < nums; i++) {
				first = first.next;
			}
		} else if (nums < 0) {
			nums = sLength - fLengh;
			for (int i = 0; i < nums; i++) {
				second = second.next;
			}
		}

		while (first != null && second != null) {
			if (first == second) {
				return first;
			} else {
				first = first.next;
				second = second.next;
			}
		}
		return null;

	}
}
