package leetCode.array.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 349 数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Leet_349_Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();
        for (int temp : nums1) {
            num1Set.add(temp);
        }
        for (int temp : nums2) {
            num2Set.add(temp);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int temp : num1Set) {
            if (num2Set.contains(temp)) {
                resultSet.add(temp);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int temp : resultSet) {
            result[index++] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        Leet_349_Intersection instance = new Leet_349_Intersection();
        System.out.println(Arrays.toString(instance.intersection(a, b)));
    }
 }
