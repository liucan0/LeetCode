package leetCode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：<br>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 * @ClassName Offer3_FindRepeatNumber
 * @Author liucan
 * @Date 2020/4/24 下午9:58
 * @Version 1.0
 **/
public class Offer3_FindRepeatNumber {
	public static int findRepeatNumber(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return -1;
		}
		Set<Integer> existSet = new HashSet<>(nums.length);
		int result = -1;
		for (int curr : nums) {
			if (existSet.contains(curr)) {
				result = curr;
				break;
			}
			existSet.add(curr);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = {2, 1, 3, 1, 2};
		System.out.println(findRepeatNumber(input));
	}
}
