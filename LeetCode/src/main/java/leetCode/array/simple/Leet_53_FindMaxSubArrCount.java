package leetCode.array.simple;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Leet_53_FindMaxSubArrCount {

    public int maxSubArr(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new NullPointerException();
        }
        //注意maxNum初始化为数组的第一个元素的值，避免负数情况时maxNum值为0
        int maxNum = nums[0], currSum = 0;
        for (int temp : nums) {
            currSum = Math.max(temp, temp + currSum);
            maxNum = Math.max(maxNum, currSum);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Leet_53_FindMaxSubArrCount instance = new Leet_53_FindMaxSubArrCount();
        int[] nums = {1, 2, -3, 4, -5, 6, 7, 8};
        System.out.println(instance.maxSubArr(nums));
    }
}
