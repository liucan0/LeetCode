package leetCode.array;

import java.util.Arrays;

/**
 * leetcode 283 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Leet_283_MoveZeroes {

    /**
     * 初始定义双指针left,right,left左边的数字都不为0,
     * right左边到left的区间内值都为0.当right指向的值不为0时，和left指向的值交换，left自增
     * @param nums
     */
    public void moveZeroes(int[] nums) {
       int left = 0, right = 0;
       while (right < nums.length) {
           if (nums[right] != 0) {
               swap(nums, left, right);
               left++;
           }
           right++;
       }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Leet_283_MoveZeroes instance = new Leet_283_MoveZeroes();
        instance.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
