package leetCode.array.medium;

import java.util.Arrays;

/**
 * leetcode 31 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Leet_31_NextPermutation {

    /**
     * 题意：给定若干个数字，将其组合为一个整数，如何将这些数字重新排列，以得到下一个更大的整数。
     * 如123下一个更大的整数位132.如果没有更大的整数，则输出最小的整数。
     * 如何得到这样的排列顺序：
     * 1.我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的大数
     * 与前面的小数蒋欢，就能得到一个更大的数。比如123456，将5和6交换就能得到一个更大的树123465
     *
     * 2.我们还希望下一个树增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻”的要求。
     * 为了满足这个要求，我们需要：
     * a.在尽可能靠右的低位进行交换，需要从后往前查找
     * b.将一个尽可能小的大数与前面的小数交换，比如123465下一个排列应该把5和4交换而不是6和4交换
     * c.将大数换到前面后，需要将大数后面的所有数重置为升序，升序排列就是最小的排列。
     * 以123465为例：首先交换5和4，得到123564；然后需要将5之后的重置为升序，得到123546.
     * 显然123546比123564更小，所以123546就是123465的下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0 ; i--) {
            /*
               从后往前遍历，找到第一个值比他前一个值大的数。以123465为例，这个值为6，位置为4
             */
            if (nums[i] > nums[i - 1]) {
                //将这个值和之后的值升序排列。此处结果为123456，排序后位置4处值为5
                Arrays.sort(nums, i, length);
                //从位置4处一直往后(位置4及之后的数为升序排列)，找到比前一位的值更小的数，交换这两个数并返回
                for (int j = i; j <length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 5};
        Leet_31_NextPermutation instance = new Leet_31_NextPermutation();
        instance.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
