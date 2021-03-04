package base;

import java.util.Arrays;

/**
 * 描述：<br>
 * 链表结点
 * @ClassName Node
 * @Author liucan
 * @Date 2019/8/22 下午3:52
 * @Version 1.0
 **/
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public static ListNode init(int[] array) {
		if (array.length == 1) {
			return new ListNode(array[0]);
		}
		ListNode node = new ListNode(array[0]);
		node.next = init(Arrays.copyOfRange(array, 1, array.length));
		return node;
	}

	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5};
		ListNode temp = ListNode.init(a);
		System.out.println(temp);
	}

}
