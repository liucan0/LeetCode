package leetCode.string;

/**
 * 描述：<br>
 * 字符串替换.替换字符串中某个字符为对应的字符(串)
 *
 * offer:4
 * @ClassName offer_4_ReplaceString
 * @Author liucan
 * @Date 2019/8/22 下午3:00
 * @Version 1.0
 **/
public class offer_4_ReplaceString {

	/**
	 * 思路：
	 * 首先统计源字符串找到有多少个需要替换的字符，创建一个替换完成后长度的字符数组，
	 * 从后往前遍历源数组，非目标字符串直接复制，遇见目标字符后往数组中插入替换值
	 * @param str 源字符数组
	 * @param target 目标字符
	 * @param replaceStr 目标字符对应的替换字符
	 * @return
	 */
	public static char[] replaceString(char[] str, char target, char[] replaceStr) {
		if (str == null || str.length == 0 || replaceStr == null || replaceStr.length == 0) {
			return str;
		}
		int count = 0;
		for (char word : str) {
			if (word == target) {
				count++;
			}
		}
		if (count == 0) {
			return str;
		}
		char[] result = new char[str.length + (replaceStr.length - 1) * count];
		for (int i = str.length - 1, j = result.length - 1; i >= 0 && j >= 0; ) {
			char temp = str[i];
			if (temp != target) {
				result[j] = temp;
				i--;
				j--;
			} else {
				for (int k = replaceStr.length - 1; k >= 0; k--) {
					result[j] = replaceStr[k];
					j--;
				}
				i--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		char[] result = replaceString(new char[]{'a','b','a','a','b'}, 'a', new char[]{'c','e'});
		System.out.println(String.valueOf(result));
	}
}
