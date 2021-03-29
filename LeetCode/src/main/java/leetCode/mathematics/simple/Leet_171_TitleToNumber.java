package leetCode.mathematics.simple;

/**
 * 描述：<br>
 * leetcode 171 excel表格名称转序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * @ClassName Leet_171_TitleToNumber
 * @Author liucan
 * @Date 2021/3/22 10:58
 * @Version 1.0
 **/
public class Leet_171_TitleToNumber {

	public int titleToNumber(String columnTitle) {
		if (columnTitle == null || columnTitle.length() <= 0) {
			return -1;
		}
		char[] chars = columnTitle.toCharArray();
		int result = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			char temp = chars[i];
			if (temp < 'A' || temp > 'Z') {
				return -1;
			}
			result += ((int)(temp - 'A') + 1) * Math.pow(26, chars.length - i - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		String temp = "ZY";
		Leet_171_TitleToNumber intance = new Leet_171_TitleToNumber();
		System.out.println(intance.titleToNumber(temp));
	}
}
