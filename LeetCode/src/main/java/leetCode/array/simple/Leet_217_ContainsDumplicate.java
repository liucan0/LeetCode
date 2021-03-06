package leetCode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 217 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class Leet_217_ContainsDumplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> countSet = new HashSet<>();
        boolean isExist = false;
        for (int temp : nums) {
            if (countSet.contains(temp)) {
                isExist = true;
            } else {
                countSet.add(temp);
            }
        }
        return isExist;
    }
}
