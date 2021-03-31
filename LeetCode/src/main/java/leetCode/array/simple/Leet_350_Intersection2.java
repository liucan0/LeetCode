package leetCode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 350 两个数组的交集2
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Leet_350_Intersection2 {

    /**
     * 先排序，再比较
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        int prev1 = 0, prev2 = 0;
        while (prev1 < length1 && prev2 < length2) {
            if (nums1[prev1] == nums2[prev2]) {
                list.add(nums1[prev1]);
                prev1++;
                prev2++;
            } else if (nums1[prev1] < nums2[prev2]) {
                prev1++;
            } else {
                prev2++;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Leet_350_Intersection2 instance = new Leet_350_Intersection2();
        System.out.println(Arrays.toString(instance.intersect(nums1, nums2)));
    }
}
