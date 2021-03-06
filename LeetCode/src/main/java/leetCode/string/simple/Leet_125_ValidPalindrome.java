package leetCode.string.simple;

/**
 * LeetCode 125 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Leet_125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        s = s.toLowerCase();
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            char left = s.charAt(begin);
            if (!isRight(left)) {
                begin++;
                continue;
            }
            char right = s.charAt(end);
            if (!isRight(right)) {
                end--;
                continue;
            }
            if (left == right) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isRight(char data) {
        return (data >= 'a' && data <= 'z') || (data >= 'A' && data <= 'Z')
                || (data >= '0' && data <= '9');
    }

    public static void main(String[] args) {
        String a = "0P";
        Leet_125_ValidPalindrome instance = new Leet_125_ValidPalindrome();
        System.out.println(instance.isPalindrome(a));
    }
}
