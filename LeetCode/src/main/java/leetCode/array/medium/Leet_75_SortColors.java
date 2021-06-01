package leetCode.array.medium;

import java.util.Arrays;

/**
 * leetcode 75 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Leet_75_SortColors {

    public void sortColors(int[] nums) {
        //head:头指针;tail:尾指针;i:当前遍历位置
        int head = 0, tail = nums.length - 1, i = 0;
        while (i <= tail) {
            if (nums[i] == 0) {
                //nums[i]==0时，交换到head节点，i++,head++
                swap(nums, i, head);
                i++;
                head++;
            } else if (nums[i] == 2) {
                //nums[i] == 2时，交换到尾节点，此时尾节点为2，nums[i]位置值未知，需要继续遍历当前节点，所以i不变，tail--;
                swap(nums, i, tail);
                tail--;
            } else if (nums[i] == 1) {
                //nuns[i]==1时，i继续向后遍历，寻找0用来交换
                i++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Leet_75_SortColors instance = new Leet_75_SortColors();
        int[] array = {2,0,1};
        instance.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
