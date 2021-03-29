package leetCode.dynamicPlanning.simple;

/**
 * 描述：<br>
 * 第二题，爬楼梯,一次可以爬一步，也可以爬两步，爬n级楼梯有多少种方法？
 * 线性动态规划，分析规律就是一个斐波那契数列.第n次的方法数为f(n)+1;
 * @ClassName Offer9_Leet70_ClimbingStairs
 * @Author liucan
 * @Date 2019/11/3 下午9:52
 * @Version 1.0
 **/
public class Offer9_Leet70_ClimbingStairs {

	public int climbStairs(int n) {
		int first = 0, second = 0, third = 1;
		for (int i = 1; i <= n; i++) {
			first = second;
			second = third;
			third = first + second;
		}
		return third;
	}

	public static void main(String[] args) {
		Offer9_Leet70_ClimbingStairs instance = new Offer9_Leet70_ClimbingStairs();
		System.out.println(instance.climbStairs(2));
	}
}
