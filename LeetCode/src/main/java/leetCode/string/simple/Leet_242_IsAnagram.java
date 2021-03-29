package leetCode.string.simple;

/**
 * leetcode 242 有效的字母异味词
 */
public class Leet_242_IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] array = new int[26];
        for (char temp : s.toCharArray()) {
            array[temp - 'a']++;
        }
        for (char temp : t.toCharArray()) {
            array[temp - 'a']--;
        }
        for (int temp : array) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }
}
