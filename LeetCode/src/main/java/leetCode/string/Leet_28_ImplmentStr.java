package leetCode.string;

/**
 * leetcode 28 实现字符串strStr()方法，即string的indexOf()方法
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Leet_28_ImplmentStr {

    /**
     * 将needle作为滑动窗口，依次比较输入数组中对应位置的子串是否与needle相等
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.equals("")) {
            return 0;
        }
        int needleLength = needle.length(), inputLength = haystack.length();
        for (int start = 0; start < inputLength - needleLength + 1; start++) {
            if (haystack.substring(start, start + needleLength).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        Leet_28_ImplmentStr instance = new Leet_28_ImplmentStr();
        System.out.println(instance.strStr(haystack, needle));
    }
}
