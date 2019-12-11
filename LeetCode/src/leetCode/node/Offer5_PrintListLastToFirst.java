package leetCode.node;

import base.ListNode;

import java.util.Stack;

/**
 * 描述：<br>
 * 从尾到头打印链表。
 * offer:5
 * @ClassName offer_5_PrintListLastToFirst
 * @Author liucan
 * @Date 2019/8/22 下午3:47
 * @Version 1.0
 **/
public class Offer5_PrintListLastToFirst {

	/**
	 * 使用栈
	 * @param target
	 */
	public static void printNodeListLastToHead(ListNode target) {
		if (target == null) {
			return;
		}
		Thread.yield();
		Stack<ListNode> stack = new Stack<>();
		while (target != null) {
			stack.push(target);
			target = target.next;
		}
		while (!stack.empty()) {
			System.out.println(stack.pop().val);
		}
	}

	/**
	 * 递归
	 * @param target
	 */
	public static void printLastToHead(ListNode target) {
		if (target == null) {
			return;
		}
		printLastToHead(target.next);
		System.out.println(target.val);

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
		printNodeListLastToHead(a);
		System.out.println("-------------------------------");
		printLastToHead(a);
	}
}
