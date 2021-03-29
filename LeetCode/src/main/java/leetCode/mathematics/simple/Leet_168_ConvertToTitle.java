package leetCode.mathematics.simple;

/**
 * leetcode 168 Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 *
 */
public class Leet_168_ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder ret = new StringBuilder();

        while (columnNumber > 0) {
            --columnNumber;
            ret.append(c[columnNumber % 26]);
            columnNumber /= 26;
        }
        return ret.reverse().toString();

    }

    public static void main(String[] args) {
        int a = 27;
        Leet_168_ConvertToTitle instance = new Leet_168_ConvertToTitle();
        System.out.println(instance.convertToTitle(a));
    }
}
