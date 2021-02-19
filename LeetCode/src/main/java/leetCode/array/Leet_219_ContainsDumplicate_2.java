package leetCode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 219 存在重复元素II
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
 * 使得nums [i] = nums [j]，并且 i和j的差的 绝对值 至多为 k。
 *
 */
public class Leet_219_ContainsDumplicate_2 {

    /**
     * 使用hashSet维护一个大小为k的滑动窗口a，从左往右遍历，若a中包含当前元素，
     * 则返回true,否则将当前元素加入a中。此时若a大小大于k,则移除最早添加的元素nums[i-k],
     * 循环完后返回false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsDuplicate(int[] nums, int k) {
        Set<Integer> countSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (countSet.contains(nums[i])) {
                return true;
            } else {
                countSet.add(nums[i]);
            }
            if (countSet.size() > k) {
                countSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
