package leetCode.node;

import base.ListNode;

/**
 * 描述：<br>
 * 合并2个排序的链表
 * @ClassName Offer_17_mergeSortedNode
 * @Author liucan
 * @Date 2019/10/31 下午10:03
 * @Version 1.0
 **/
public class Offer17_Leet21_mergeSortedNode {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode first = l1;
		ListNode second = l2;
		ListNode result = null;

		if (first.val >= second.val) {
			result = new ListNode(second.val);
			second = second.next;
		} else {
			result = new ListNode(first.val);
			first = first.next;
		}
		ListNode resultCurr = result;
		while (first != null && second != null) {
			if (first.val >= second.val) {
				resultCurr.next = new ListNode(second.val);
				second = second.next;
				resultCurr = resultCurr.next;
			} else {
				resultCurr.next = new ListNode(first.val);
				first = first.next;
				resultCurr = resultCurr.next;
			}
		}
		if (first != null) {
			resultCurr.next = first;
		}
		if (second != null) {
			resultCurr.next = second;
		}
		return result;
	}

	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		} else if(l2==null) {
			return l1;
		} else if(l1.val<l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next =  mergeTwoLists(l1,l2.next);
			return l2;
		}
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
		ListNode result = mergeTwoLists(a, d);
		while (a.next != null) {
			System.out.println(a.val);
			a = a.next;
		}
	}
}
