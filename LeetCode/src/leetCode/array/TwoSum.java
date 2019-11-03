package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 * @author Administrator
 *
 */
public class TwoSum {

	/**
	 * O(n)时间复杂度，O(n)空间复杂度。
	 * 遍历时将遍历过的
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.containsKey(key)) {
				return new int[] {map.get(key), i};
			}
			map.put(nums[i], i);
		}
		throw new RuntimeException();
	}

	/**
	 * O(n2)时间复杂度，O(1)空间复杂度
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++){
			int first = nums[i];
			for(int j = nums.length - 1; j > i; j--){
				int second = nums[j];
				if(first + second == target){
					return new int[] {i,j};
				}
			}
		}
		return null;
    }


}
