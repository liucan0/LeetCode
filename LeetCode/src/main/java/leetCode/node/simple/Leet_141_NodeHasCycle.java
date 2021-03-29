package leetCode.node.simple;

import base.ListNode;

/**
 * 描述：<br>
 * 判断链表是否有环。
 * @ClassName NodeHasCycle
 * @Author liucan
 * @Date 2019/11/1 下午4:47
 * @Version 1.0
 **/
public class Leet_141_NodeHasCycle {

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		//指针，每次走一步
		ListNode first = head;
		//指针，每次走两步
		ListNode second = head;
		//快的指针先走，每走一步与当前慢的指针比较，相等则有环，两次都不相等则慢指针往前一步。
		while (second != null) {
			second = second.next;
			if (first == second) {
				return true;
			}
			if (second != null && second.next != null) {
				second = second.next;
				if (first == second) {
					return true;
				}
			}
			first = first.next;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		d.next = e;
		c.next = d;
		b.next = c;
		a.next = b;

		boolean result = hasCycle(d);
		System.out.println(result);
	}
}
