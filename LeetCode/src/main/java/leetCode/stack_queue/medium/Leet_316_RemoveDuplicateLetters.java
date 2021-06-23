package leetCode.stack_queue.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 316 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class Leet_316_RemoveDuplicateLetters {

    /**
     * 字典序：abbbb<baaaa
     * 使用单调栈，首先统计每个字母的出现次数，遍历到字母时，将其出现次数减1,
     * 如果栈内不为空,且当前栈顶元素a的字典序比当前元素b大，且后续出现次数大于0，
     * 则弹出a,压入b;若a后续出现次数为0，则不弹出a，直接压入b;如果a的字典序比b小，则压入b
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char temp : s.toCharArray()) {
            int index = temp - 'a';
            charCount[index]--;
            //栈中已包含当前值，跳过
            if (stack.contains(temp)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > temp) {
                //栈不为空且栈顶元素大于当前值时，如果栈顶元素后续还会出现，则弹出，否则停止循环
                if (charCount[stack.peek() - 'a'] == 0) {
                    break;
                }
                stack.pop();
            }
            //将当前元素压入栈中
            stack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leet_316_RemoveDuplicateLetters instance = new Leet_316_RemoveDuplicateLetters();
        String s = "cbacdcbc";
        System.out.println(instance.removeDuplicateLetters(s));
    }
}
