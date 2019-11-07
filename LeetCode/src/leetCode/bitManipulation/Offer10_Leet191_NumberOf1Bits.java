package leetCode.array;

/**
 * 描述：<br>
 * 输入一个无符号整数，返回其二进制中1的数量
 * @ClassName Offer10_Leet191_Numberof1Bits
 * @Author liucan
 * @Date 2019/11/7 下午8:47
 * @Version 1.0
 **/
public class Offer10_Leet191_NumberOf1Bits {

	/**
	 * 先判断二进制中最右边一位是不是1，再把证书右移1位，再判断是否为1.
	 * 每次移动一位直到整数变为0;
	 * 可以让整数与1进行位与运算，若最右边是1，则结果为1，否则为0;
	 * 例：11111111111
	 *   &00000000001；结果为0000000001，即1
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			/**
			 * 负数使用>>右移时会因为高位补全陷入无限循环，所以要用>>>进行无符号右移
			 */
			n = n >>> 1;
		}
		return count;
	}

	/**
	 * 解法二：把一个整数减去1，再和原来的数做与运算，就会把二进制值中最右边的1变成0，
	 * 二进制中有多少个1就能进行多少次运算
	 * @param n
	 * @return
	 */
	public static int hammingWeight1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = -12;
		System.out.println(Offer10_Leet191_NumberOf1Bits.hammingWeight(a));
		System.out.println("二进制" + Integer.toBinaryString(a));
	}
}
