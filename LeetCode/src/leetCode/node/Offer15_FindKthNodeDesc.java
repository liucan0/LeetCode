package leetCode.node;

import base.ListNode;

/**
 * 描述：<br>
 * 找到链表中倒数第K个结点.
 * 定义两个指针，一个指针向前k步，第二个指针在开始行动。
 * 第一个指针达到末尾时，第二个指针所在处即为倒数第K处
 * @ClassName Offer_15_FindKthNodeDesc
 * @Author liucan
 * @Date 2019/10/31 下午8:43
 * @Version 1.0
 **/
public class Offer15_FindKthNodeDesc {

	public static ListNode findKthNodeDesc(ListNode root, int k) {
		if (root == null || k <= 0) {
			return null;
		}
		ListNode firstNode = root;
		ListNode secondNode = root;
		//第一个指针前进k-1步。
		for (int i = 1; i < k; i++) {
			if (firstNode.next != null) {
				firstNode = firstNode.next;
			} else {
				return null;
			}
		}
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		return secondNode;

	}

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(7);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(8);
		d.next = e;
		c.next = d;
		b.next = c;
		a.next = b;
		ListNode last = findKthNodeDesc(a, 6);
		System.out.println(last.val);
	}
}
