package base;

/**
 * 描述：<br>
 * 带随机指针的链表结点
 * @ClassName Node
 * @Author liucan
 * @Date 2019/8/22 下午3:52
 * @Version 1.0
 **/
public class RandomNode {
	public int val;
	public RandomNode next;
	public RandomNode randomNode;

	public RandomNode(int val, RandomNode next) {
		this.val = val;
		this.next = next;
	}

	public RandomNode(int val, RandomNode next, RandomNode randomNode) {
		this.val = val;
		this.next = next;
		this.randomNode = randomNode;
	}

}
