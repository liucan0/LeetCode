package leetCode.node.simple;

import base.ListNode;

/**
 * 描述：<br>
 * 删除倒数第k个结点并返回头结点
 * @ClassName DeleteKthNodeDesc
 * @Author liucan
 * @Date 2019/10/31 下午8:55
 * @Version 1.0
 **/
public class Leet_19_DeleteKthNodeDesc {

	public static ListNode deleteKthNodeDesc(ListNode root, int k) {
		if (root == null || k <= 0) {
			return null;
		}
		ListNode firstNode = root;
		ListNode secondNode = root;
		//倒数第k+1个结点
		ListNode kPre = null;
		for (int i = 0; i < k - 1; ++i) {
			if (firstNode.next != null) {
				firstNode = firstNode.next;
			} else {
				return root;
			}
		}
		//第一个指针已到末尾
		while (firstNode.next != null) {
			if (firstNode.next.next == null) {
				kPre = secondNode;
			}
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}

		if (kPre != null) {
			kPre.next = secondNode.next;
		} else {//倒数第k+1个结点为null
			//两指针重合，说明只有1个元素
			if (firstNode == secondNode) {
				return null;
			} else {
				//要删除的是头结点
				root = secondNode.next;
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
		ListNode last = deleteKthNodeDesc(c, 3);
		System.out.println(1);
	}
}
