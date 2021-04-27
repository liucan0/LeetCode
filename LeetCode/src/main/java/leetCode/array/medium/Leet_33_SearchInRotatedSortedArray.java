package leetCode.array.medium;

/**
 * leetcode 33 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class Leet_33_SearchInRotatedSortedArray {

    /**
     * 二分法。旋转数组被分为2个部分时，一定有一部分是有序(升序)的。
     * 于是我们在常规二分查找时，查看当前mid位置分割出来的两个部分[left,mid]和[mid+1,right]
     * 那个部分是有序的，并根据有序的那个部分确定我们该怎么改变二分查找的上下界，因为我们能够
     * 根据有序的那部分判断target在不在这个部分：
     * 1.如果[left,mid]有序，且target在其中，则搜索范围应缩小为[l,mid-1],
     * 否则在[mid+1,right]中寻找
     * 2.如果在[mid+1,right]有序，且target在其中，则应在[mid+1,right]中查找，
     * 否在在[left,mid-1]中查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int medium = left + (right - left) / 2;
            if (nums[medium] == target) {
                return medium;
            }
            if (nums[0] <= nums[medium]) {
                //旋转点在medium左边，medium右边升序排列
                if (nums[medium] > target && nums[0] <= target) {
                    right = medium - 1;
                } else {
                    left = medium + 1;
                }
            } else {
                //旋转点在medium右边，medium左侧升序排列
                if (nums[medium] < target && target <= nums[nums.length - 1]) {
                    left = medium + 1;
                } else {
                    right = medium - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        Leet_33_SearchInRotatedSortedArray instance = new Leet_33_SearchInRotatedSortedArray();
        System.out.println(instance.search(a, 2));
    }
}
