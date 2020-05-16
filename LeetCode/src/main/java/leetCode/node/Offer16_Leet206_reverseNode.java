package leetCode.node;

import base.ListNode;

/**
 * 描述：<br>
 * 反转链表
 * @ClassName Offer_24_reverseNode
 * @Author liucan
 * @Date 2019/10/26 下午11:40
 * @Version 1.0
 **/
public class Offer16_Leet206_reverseNode {

	public ListNode reversNode(ListNode node) {
		if (node == null) {
			return null;
		}
		//记录当前结点和前一结点
		ListNode pre = null;
		ListNode curr = node;
		while (curr != null) {
			//记录下一个结点
			ListNode nextTemp = curr.next;
			//将指向下一结点的指针指向前一节点。
			curr.next = pre;
			//往后遍历
			pre = curr;
			curr = nextTemp;
		}
		return pre;
	}
}
