package leetCode.node;

import base.RandomNode;

import java.util.HashMap;

/**
 * 描述：<br>
 * 复制带随机指针的复杂链表
 * @ClassName Offer_26_CopyRandomList
 * @Author liucan
 * @Date 2019/10/31 下午10:56
 * @Version 1.0
 **/
public class Offer26_Leet138_CopyRandomList {

	public static RandomNode copyRandomList(RandomNode root) {
		if (root == null) {
			return root;
		}
		HashMap<RandomNode, RandomNode> map = new HashMap<>();
		RandomNode curr = root;
		while (curr != null) {
			map.put(curr, new RandomNode(curr.val, null));
			curr = curr.next;
		}
		curr = root;
		RandomNode copy = map.get(curr);
		RandomNode copycopy = copy;
		while (curr != null) {
			copycopy = map.get(curr);
			copycopy.next = curr.next == null ? null : map.get(curr.next);
			copycopy.randomNode = map.get(curr.randomNode);
			curr = curr.next;
		}
		return copy;
	}

	public static void main(String[] args) {
		RandomNode a = new RandomNode(1, null);
		RandomNode b = new RandomNode(2, a);
		RandomNode c = new RandomNode(3, b);
		RandomNode d = new RandomNode(4, c);
		RandomNode e = new RandomNode(5, d);
		a.randomNode = b;
		b.randomNode = c;
		c.randomNode = d;
		d.randomNode = e;
		e.randomNode = a;
		copyRandomList(e);
	}
}
