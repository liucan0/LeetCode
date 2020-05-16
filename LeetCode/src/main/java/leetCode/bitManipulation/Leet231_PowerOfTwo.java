package leetCode.bitManipulation;

/**
 * 描述：<br>
 * 判断一个整数是不是2的幂
 * @ClassName Leet231_PowerofTwo
 * @Author liucan
 * @Date 2019/11/7 下午9:53
 * @Version 1.0
 **/
public class Leet231_PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if (n < 0) {
			return false;
		}
        int count = 0;
        while (n != 0) {
        	if (count > 1) {
        		break;
	        }
        	n = (n - 1) & n;
        	count++;
        }
        return count == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(3));
	}
}
