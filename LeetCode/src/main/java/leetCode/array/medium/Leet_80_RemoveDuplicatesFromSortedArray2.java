package leetCode.array.medium;

import java.util.Arrays;

/**
 * leetcode 80 删除有序数组中的重复项2
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class Leet_80_RemoveDuplicatesFromSortedArray2 {

    /**
     * 双指针。
     * 因为给定数组有序，所以相同元素必定连续，可以遍历数组检查每一个元素是否应该被保留，如果应该被保留，
     * 就将其移动到指定位置。慢指针slow表示已处理的数组长度，快指针fast表示已检查过的数组长度。
     * 因为要求元素最多出现两次，所以需要检查上上个应该被保留的元素nums[slow-2]是否和当前元素nums[fast]相等。
     * 当且仅当nums[slow-2]=nums[fast]是，元素nums[fast]不应该被保留。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int idx = 0;//表示符合要求的元素的位置
        for (int curr : nums) {
            /*
            idx小于2时，保留原来元素；idx的上上个元素不等于当前值时，说明元素未重复，设置nums[idx]值为当前值，idx++；
            上上个元素等于当前值时，idx位置不变，继续向后遍历元素，直到遇到与idx的上上个元素不同的值
             */
            if (idx < 2 || nums[idx - 2] != curr) {
                nums[idx] = curr;
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Leet_80_RemoveDuplicatesFromSortedArray2 instance = new Leet_80_RemoveDuplicatesFromSortedArray2();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(instance.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        
    }
}
