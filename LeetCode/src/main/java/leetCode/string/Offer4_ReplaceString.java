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
public class Offer4_ReplaceString {
	/**
	 * 思路：
	 * 首先统计源字符串找到有多少个需要替换的字符，创建一个替换完成后长度的字符数组，
	 * 从后往前遍历源数组，非目标字符串直接复制，遇见目标字符后往数组中插入替换值
	 * @param str 源字符数组
	 * @param target 目标字符
	 * @param val 目标字符对应的替换字符
	 * @return
	 */
	public static char[] replaceStr(char[] str, char target, char[] val) {
		if (str == null || str.length == 0) {
			return str;
		}
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == target) {
				count++;
			}
		}
		if (count == 0) {
			return str;
		}
		char[] newStr = new char[str.length + count * (val.length - 1)];
		for (int i = 0, j = 0; i < str.length; i++) {
			if (str[i] == target) {
				for (int k = 0; k < val.length; k++) {
					newStr[j++] = val[k];
				}
			} else {
				newStr[j++] = str[i];
			}
		}
		return newStr;

	}

	public static void main(String[] args) {
		char[] result = replaceStr(new char[]{'a','b','a','a','b'}, 'a', new char[]{'c','e'});
		System.out.println(String.valueOf(result));
	}


}
