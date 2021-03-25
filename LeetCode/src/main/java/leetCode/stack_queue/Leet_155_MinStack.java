package leetCode.stack_queue;

import java.util.Stack;

/**
 * leetcode 155 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class Leet_155_MinStack {
    private Stack<Integer> valStack;
    private Stack<Integer> minStack;

    public Leet_155_MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 将元素x入栈，同时在最小值栈中压入当前最小值
     * @param val
     */
    public void push(int val) {
        valStack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            int min = minStack.peek();
            minStack.push(val < min ? val : min);
        }
    }

    /**
     * 删除栈顶元素,最小值栈同步删除栈顶元素
     */
    public void pop() {
        valStack.pop();
        minStack.pop();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {
        return valStack.peek();
    }

    /**
     * 检索栈中最小元素
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Leet_155_MinStack instance = new Leet_155_MinStack();
        instance.push(5);
        instance.push(3);
        instance.push(2);
        instance.push(4);
        System.out.println(instance.getMin());
        instance.pop();
        instance.pop();
        System.out.println(instance.getMin());

    }
}
