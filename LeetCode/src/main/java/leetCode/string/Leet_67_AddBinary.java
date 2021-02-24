package leetCode.string;

/**
 * leetcode 67 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Leet_67_AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int length = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < length; i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        Leet_67_AddBinary instance = new Leet_67_AddBinary();
        System.out.println(instance.addBinary(a, b));
    }
}
