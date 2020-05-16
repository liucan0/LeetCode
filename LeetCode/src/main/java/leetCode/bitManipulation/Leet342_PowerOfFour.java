package leetCode.bitManipulation;

/**
 * 描述：<br>
 * 判断一个数是不是4的幂
 * @ClassName Leet342_PowerOfFour
 * @Author liucan
 * @Date 2019/11/8 下午12:03
 * @Version 1.0
 **/
public class Leet342_PowerOfFour {

	public static boolean powerOfFour(int n) {
		if (n <= 0) {
			return false;
		}
		while (n > 0 && (n % 4) == 0) {
			n = n >>> 2;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		System.out.println(powerOfFour(4));
		System.out.println(powerOfFour(5));

	}
}
