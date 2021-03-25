package leetCode.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：<br>
 * offer:7, leetcode:232
 *
 * 用栈实现队列。
 *
 *
 * @ClassName Offer_7_ImplementStackUsingQueue
 * @Author liucan
 * @Date 2019/8/23 上午11:10
 * @Version 1.0
 **/
public class Offer7_ImplementStackUsingQueue {
	//存放压入的数据
	Queue<Integer> first = new LinkedList<>();
	//存放交换的数据
	Queue<Integer> second = new LinkedList<>();
	private int top;
	/**
	 * 压栈
	 * @param x
	 */
	public void push(int x) {
		first.add(x);
		top = x;
	}

	/**
	 * 弹出并返回.弹出后需要更新top值
	 * @return
	 */
	public int pop() {
		if (second.isEmpty()) {
			while (!first.isEmpty()) {
				int x = first.remove();
				if (first.isEmpty()) {
					return x;
				}
				second.add(x);
				top=x;
			}
		} else {
			while (!second.isEmpty()) {
				int x = second.remove();
				if (second.isEmpty()) {
					return x;
				}
				first.add(x);
				top=x;
			}


		}
		throw new RuntimeException("hah");
	}

	/**
	 * 返回栈顶元素
	 * @return
	 */
	public int top() {
		return top;
	}

	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean empty() {
		return first.isEmpty() && second.isEmpty();
	}

	public static void main(String[] args) {
		Offer7_ImplementStackUsingQueue stack = new Offer7_ImplementStackUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
	}
}
