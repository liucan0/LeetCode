package leetCode.node;

import base.ListNode;

/**
 * 描述：<br>
 * 在O(1)时间内删除结点
 * @ClassName Offer_13_deleteNodeInO1
 * @Author liucan
 * @Date 2019/10/31 下午8:21
 * @Version 1.0
 **/
public class Offer_13_deleteNodeInO1 {

	/**
	 * 前提：要删除的结点在链表中
	 * 有误。跳过此题。
	 * @param root 根节点
	 * @param target 目标结点
	 * @return
	 */
	public static ListNode deleteNode(ListNode root, ListNode target) {
		if (root == null || target == null) {
			return root;
		}
		while (true) {
			if (target.next != null) {
				target.val = target.next.val;
				target = target.next;
			} else {
				target = null;
				break;
			}

		}
		return root;
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
		deleteNode(a, b);
		while (a.next != null) {
			System.out.println(a.val);
			a = a.next;
		}
	}
}
