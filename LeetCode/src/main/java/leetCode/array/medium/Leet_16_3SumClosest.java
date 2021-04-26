package leetCode.array.medium;

import java.util.Arrays;

/**
 * leetcode 16 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class Leet_16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, ans = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //相同的数只能使用一次，因此跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = length - 1;
            while (start < end) {
                //值相等，返回
                int value = nums[i] + nums[start] + nums[end];
                if (value == target) {
                    return value;
                }
                //绝对值小于当前min，更新min的值
                int abs = Math.abs(value - target);
                if (abs < min) {
                    min = abs;
                    ans = value;
                }
                if (value > target) {
                    //值比目标值大，end指针指向的较大数向左移动
                    end--;
                } else {
                    //否则start指向的较小数向右移动
                    start++;
                }
            }
        }
        return ans;
    }
}
