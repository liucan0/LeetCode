package leetCode.array.simple;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 */
public class Leet_88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            result[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (k < result.length) {
            result[k++] = i < m - 1 ? nums1[i++] : nums2[j++];
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        Leet_88_MergeSortedArray instance = new Leet_88_MergeSortedArray();
        instance.merge(a, 3, b, 3);
        for (int temp : a) {
            System.out.println(temp);
        }
    }
}
