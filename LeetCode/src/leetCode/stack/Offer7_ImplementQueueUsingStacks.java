package leetCode.stack;

import java.util.Stack;

/**
 * 描述：<br>
 *     offer:7, leetcode:232
 * 用两个栈实现队列.
 * 输入元素先压入栈1，输入完成后依次弹出压入栈2，在弹出。
 *
 * @ClassName Offer_7_ImplementQueueUsingStacks
 * @Author liucan
 * @Date 2019/8/23 上午10:19
 * @Version 1.0
 **/
public class Offer7_ImplementQueueUsingStacks {
	//存放入栈顺序元素
	Stack<Integer> first = new Stack<>();
	//存放出栈顺序元素
	Stack<Integer> second = new Stack<>();

	/**
	 * 往队列中添加元素
	 * @param x
	 */
	public void push(int x) {
		first.push(x);
	}

	/**
	 * 弹出并删除队列头元素
	 * @return
	 */
	public int pop() {
		if (first.empty() && second.empty()) {
			throw new RuntimeException("asdf");
		}
		if (!second.empty()) {
			return second.pop();
		} else {
			//将入栈顺序的元素转换为出栈
			while (!first.empty()) {
				second.push(first.pop());
			}
			return second.pop();
		}
	}

	/**
	 * 获取队列头元素
	 * @return
	 */
	public int peek() {
		if (first.empty() && second.empty()) {
			throw new RuntimeException("asdf");
		}
		if (!second.empty()) {
			return second.peek();
		} else {
			//将入栈顺序的元素转换为出栈
			while (!first.empty()) {
				second.push(first.pop());
			}
			return second.peek();
		}
	}

	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean empty() {
		return first.empty() && second.empty();
	}

	public static void main(String[] args) {
		Offer7_ImplementQueueUsingStacks queue = new Offer7_ImplementQueueUsingStacks();
		queue.push(7);
		queue.push(6);
		queue.push(5);
		queue.push(4);
		queue.push(3);
		queue.push(2);
		queue.push(1);
		while (!queue.empty()) {
			System.out.println(queue.peek());
			queue.pop();
		}
	}
}
