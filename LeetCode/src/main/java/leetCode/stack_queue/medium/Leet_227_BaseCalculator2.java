package leetCode.stack_queue.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 227 基础计算器2
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 */
public class Leet_227_BaseCalculator2 {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        //遇到加号入栈当前值
                        stack.push(num);
                        break;
                    case '-':
                        //遇到减号入栈当前值相反数
                        stack.push(-num);
                        break;
                    case '*':
                        //遇到乘号先弹出栈顶元素a，再入栈a与当前值之积
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        //遇到除号先弹出栈顶元素a,在入栈a与当前元素之商
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Leet_227_BaseCalculator2 instance = new Leet_227_BaseCalculator2();
        String s = " 3+5 / 2 ";
        System.out.println(instance.calculate(s));
    }
}
