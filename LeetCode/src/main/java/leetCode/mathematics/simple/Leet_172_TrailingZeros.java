package leetCode.mathematics.simple;

/**
 * 描述：<br>
 * leetcode 172 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @ClassName Leet_172_TrailingZeros
 * @Author liucan
 * @Date 2021/3/22 13:37
 * @Version 1.0
 **/
public class Leet_172_TrailingZeros {

	/**
	 * 方法1：使用bigInteger计算阶乘完的值，再数其中0的个数(复杂度O(n)))
	 * 方法2：
	 * @param n
	 * @return
	 */
	public int trailingZeros(int n) {
		return n < 5 ? 0 : n / 5 + trailingZeros(n / 5);
	}
}
