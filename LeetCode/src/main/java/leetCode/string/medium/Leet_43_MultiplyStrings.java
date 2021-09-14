package leetCode.string.medium;

/**
 * leetcode 43 字符串相乘
 * 给定两个字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，
 * 他们的乘积页表示为字符串形式
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Leet_43_MultiplyStrings {

    /**
     * num2的每个字符与num1相乘，计算最终结果
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] ansArr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0 ; j--) {
                int val2 = num2.charAt(j) - '0';
                ansArr[i + j + 1] += val1 * val2;
            }
        }
        for (int i = len1 + len2 - 1; i > 0 ; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < len1 + len2) {
            sb.append(ansArr[index]);
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer num1 = 2, num2 = 23;
        Leet_43_MultiplyStrings instance = new Leet_43_MultiplyStrings();
        System.out.println(instance.multiply(num1.toString(), num2.toString()));
    }
}
