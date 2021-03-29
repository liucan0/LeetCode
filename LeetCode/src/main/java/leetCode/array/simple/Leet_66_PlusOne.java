package leetCode.array.simple;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 输入：digits = [1,2,3]
 输出：[1,2,4]
 解释：输入数组表示数字 123。
 */
public class Leet_66_PlusOne {

    public int[] plusOne(int[] nums) {
        for (int i = nums.length - 1; i >= 0 ; i--) {
            nums[i]++;
            nums[i] = nums[i] % 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }

    public static void main(String[] args) {
        Leet_66_PlusOne instance = new Leet_66_PlusOne();
        int[] nums = {9, 9, 9};
        nums = instance.plusOne(nums);
        for (int temp : nums) {
            System.out.println(temp);
        }
    }
}
