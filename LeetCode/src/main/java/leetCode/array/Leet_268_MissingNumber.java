package leetCode.array;

/**
 * leetcode 268 丢失的数字
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 */
public class Leet_268_MissingNumber {

    /**
     * 连续n个数字之和为n*(n + 1)/2, 求出连续和之后减去输入数组之和，差即为输入数组缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length * (nums.length + 1) / 2;
        int count = 0;
        for (int temp : nums) {
            count += temp;
        }
        return n - count;
    }
}
