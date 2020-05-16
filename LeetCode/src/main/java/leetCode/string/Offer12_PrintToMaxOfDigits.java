package leetCode.string;

/**
 * 描述：<br>
 * 输入一个n,打印1-n之间所有的数
 * @ClassName Offer12_PrintToMaxOfDigits
 * @Author liucan
 * @Date 2019/11/14 上午10:01
 * @Version 1.0
 **/
public class Offer12_PrintToMaxOfDigits {

	public static void printToMaxOfDigits(int n ) {
		if (n <= 0) {
			return;
		}
		String[] number = new String[n];
		for (int i = 0; i < 10; i++) {
			number[0] = String.valueOf(i);
			printToMaxOfDigitsRecursively(number, n, 0);
		}
	}

	//全排列
	private static void printToMaxOfDigitsRecursively(String[] number, int length, int index) {
		if (index == length - 1) {
			StringBuilder sb = new StringBuilder();
			for (String str : number) {
				sb.append(str);
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index + 1] = String.valueOf(i);
			printToMaxOfDigitsRecursively(number, length, index + 1);
		}
	}

	public static void main(String[] args) {
		printToMaxOfDigits(4);
	}
}
