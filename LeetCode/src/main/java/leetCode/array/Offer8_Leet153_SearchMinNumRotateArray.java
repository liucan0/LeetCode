package leetCode.array;

/**
 * 描述：<br>
 * 搜索旋转数组中的最小值
 * @ClassName Offer8_Leet153_SearchMinNumRotateArray
 * @Author liucan
 * @Date 2019/11/1 下午9:14
 * @Version 1.0
 **/
public class Offer8_Leet153_SearchMinNumRotateArray {

	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0, right = nums.length - 1;
		if (nums[right] > nums[0]) {
			return nums[0];
		}
		while (right >= left) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			if (nums[mid] > nums[0]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		Integer a = 1;
		a.notify();
		return -1;
	}
}
