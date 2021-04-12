package leetCode.string.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 3 无重复字符最长子串
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Leet_3_LengthOfLongestSubstring {

    /**
     * 使用滑动窗口：1、使用两个指针表示字符串中的某个子串的左右边界
     * 2.每一步操作中，会将左指针向右移动一格，表示开始枚举下一个字符作为起始位置，
     * 然后不断向右移动右指针，但需要保证两个指针对应的子串中没有重复的字符。
     * 在移动结束后，这个子串就对应着以左指针开始的不包含重复字符的最长子串，记录下这个子串的长度
     * 3.返回记录下的最大长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        //保存当前子串中的元素，用来判断重复字符
        Set<Character> charSet = new HashSet<>();
        //i为左指针，right为右指针，result为子串长度
        int right = -1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                //左指针每向右移动一格，从窗口中移除前一个字符
                charSet.remove(s.charAt(i - 1));
            }
            //不断移动右指针，直到末尾或遇见重复字符
            while (right + 1 < s.length() && !charSet.contains(s.charAt(right + 1))) {
                charSet.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;

    }

    public static void main(String[] args) {
        Leet_3_LengthOfLongestSubstring instance = new Leet_3_LengthOfLongestSubstring();
        System.out.println(instance.lengthOfLongestSubstring("abcabcbb"));
    }
}
