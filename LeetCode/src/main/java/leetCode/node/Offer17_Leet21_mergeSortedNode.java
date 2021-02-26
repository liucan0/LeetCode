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

	/**
	 * 迭代
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		//设置头结点方便返回，第一个节点后的就是合并的链表界定啊
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;

	}

	/**
	 * 递归
	 * @param l1
	 * @param l2
	 * @return
	 */
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
	}
}
