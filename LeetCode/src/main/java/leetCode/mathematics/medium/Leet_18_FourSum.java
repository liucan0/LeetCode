package leetCode.mathematics.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class Leet_18_FourSum {

    /**
     * 排序+双指针
     * 为避免枚举到重复四元组，需要保证每一重循环枚举到的元素不小于其上一重循环枚举到的元素，
     * 且在同一重循环中不能多次枚举到相同的元素。
     * 因此需要对数组进行排序，并在循环过程中遵循以下两点，
     * 1.每一种循环枚举到的下表必须大于上一重循环枚举到的下标
     * 2.同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素
     * 如此可以避免枚举到重复四元组，再使用双指针代替最内层循环
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //剪枝，当前最小4数之和大于target,跳出循环(后续和都比当前和大)
            if (nums[i] + 0L + nums[i + 1] + nums[i +2] + nums[i + 3] > target) {
                break;
            }
            //剪枝，当前最大4数之和小于target, 进行下一个循环
            if (nums[i] + 0L + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                //跳过重复元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //剪枝，当前相邻4位和大于target,结束当前循环,i++
                if (nums[i] + 0L + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //剪枝，最后四位数小于target,进行下一次循环，j++
                if (nums[i] + 0L + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                //双指针，枚举后面两个数
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = nums[i] + 0L + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        //如果值相等，保存当前四个数，然后左指针右移直到遇到不同的数，右指针左移直至遇到不同的数
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        //和比target小，左指针右移
                        left++;
                    } else {
                        //和比target大，右指针左移
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        Leet_18_FourSum instance = new Leet_18_FourSum();
        List<List<Integer>> result = instance.fourSum(nums, target);
        System.out.println(JSON.toJSONString(result));
    }
}
