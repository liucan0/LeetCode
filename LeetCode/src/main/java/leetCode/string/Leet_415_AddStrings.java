package leetCode.string;

/**
 * leetcode 415 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class Leet_415_AddStrings {

    /**
     * 类似二进制字符串相加
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        StringBuilder sb = new StringBuilder();
        int total = 0;
        int length = Math.max(num1.length(), num2.length());
        for (int i = 0; i < length; i++) {
            total += i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            total += i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            sb.append(total % 10);
            total /= 10;
        }
        if (total > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "100";
        String b = "900";
        Leet_415_AddStrings instance = new Leet_415_AddStrings();
        System.out.println(instance.addStrings(a, b));
    }
}
