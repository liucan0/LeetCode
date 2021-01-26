package leetCode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class Leet_35_SearchOrInsertNum {

    /**
     * 基于二分查找。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums.length;
        int left = 0, right = result - 1;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (target <= nums[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6};
        Leet_35_SearchOrInsertNum instance = new Leet_35_SearchOrInsertNum();
        System.out.println(instance.searchInsert(nums, 5));
    }
}
