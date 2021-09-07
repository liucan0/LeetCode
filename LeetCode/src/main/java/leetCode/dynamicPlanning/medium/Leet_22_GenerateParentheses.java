package leetCode.dynamicPlanning.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class Leet_22_GenerateParentheses {

    /**
     * 回溯法
     * 递归生成序列，长度为n的序列就是在长度为n-1的序列前加一个(或)
     * 注意需要在序列有效时才添加括号，可以通过跟踪已放置的左右括号的数量来办到。
     * 如果左括号数量不大于n，可以放一个左括号；如果右括号数量小于左括号数量，可以放置一个右括号
     * @param n
     * @return
     */
    public List<String> generateParentheses(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     *
     * @param ans 结果集
     * @param cur 当前序列
     * @param open 左括号数量
     * @param close 右括号数量
     * @param max 长度
     */
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        //当前序列已生成
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        //左括号数量小于max，可添加左括号
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            //回溯.
            cur.deleteCharAt(cur.length() - 1);
        }
        //右括号数量小于左括号，可添加右括号
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            //回溯
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        Leet_22_GenerateParentheses instance = new Leet_22_GenerateParentheses();
        System.out.println(JSON.toJSONString(instance.generateParentheses(3)));
    }
}
