package leetCode.string;

/**
 * leetcode 387 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Leet_387_firstUniqChar {

    /**
     * 字符串中只包含小写字母，使用26位数组映射a-z，
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (countArr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "loveleetcode";
        Leet_387_firstUniqChar instance = new Leet_387_firstUniqChar();
        System.out.println(instance.firstUniqChar(a));
    }
}
