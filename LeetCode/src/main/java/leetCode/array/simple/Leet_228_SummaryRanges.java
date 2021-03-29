package leetCode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 228 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，
 * nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 例：输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class Leet_228_SummaryRanges {

    /**
     * 双指针定义区间的低位low和高位high，low从0开始遍历数组并递增一次，
     * 若与后一个数的差值为1则一直递增直到数组末尾或者差值大于1.
     * 此时i-1则为高位，格式化字符串添加到list中最后返回。
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            int high = i - 1;
            resultList.add(this.formatString(nums, low, high));
        }
        return resultList;
    }

    private String formatString(int[] nums, int low, int high) {
        StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
        if (low < high) {
            sb.append("->").append(nums[high]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leet_228_SummaryRanges instance = new Leet_228_SummaryRanges();
        int[] nums = {0,2,3,4,6,8,9};
        List<String> result = instance.summaryRanges(nums);
        System.out.println(result);
    }
}
