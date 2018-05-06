package array;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 * @author Administrator
 *
 */
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		if (nums == null) {
            return 0;
        } 
        int curSum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            max = Math.max(curSum, max);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
	}
	public static void main(String[] args) {
		int[] list = {1,4,5,6,7,-1,-2,-3,-4};
		System.out.println(new MaxSubArray().maxSubArray(list));
	}
}
