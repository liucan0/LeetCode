package leetCode.string.simple;

/**
 * leetcode 14 字符串最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Leet_14_LongestCommonPrefix {

    /**
     * 纵向扫描，取第一个字符串a为基准，对a中的每一个字符都与数组中
     * 其他字符串相同位置的进行比较，若不相等则返回,相等则继续比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] input = {"flower","flow","flight"};
        Leet_14_LongestCommonPrefix instance = new Leet_14_LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(input));
    }
}



