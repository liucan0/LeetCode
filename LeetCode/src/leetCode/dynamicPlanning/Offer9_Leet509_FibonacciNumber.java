package leetCode.dynamicPlanning;

/**
 * 描述：<br>
 * 题目1：斐波那契数列
 * @ClassName Offer9_Leet509_FibonacciNumber
 * @Author liucan
 * @Date 2019/11/3 下午9:24
 * @Version 1.0
 **/
public class Offer9_Leet509_FibonacciNumber {

	//递归
	public int fib(int N) {
		if (N < 0) {
			throw new RuntimeException();
		}
		if (N == 0) {
			return 0;
		} else if (N == 1) {
			return 1;
		}
		return fib(N - 2) + fib(N - 1);
	}

	//迭代
	public int fib1(int N) {
		if (N < 0) {
			throw new RuntimeException();
		}
		if (N == 0) {
			return 0;
		} else if (N == 1) {
			return 1;
		}
		int first = 0;
		int second = 1;
		for (int i = 0; i < N - 1; i++) {
			int temp = second;
			second = first + second;
			first = temp;
		}
		return second;
	}
}
