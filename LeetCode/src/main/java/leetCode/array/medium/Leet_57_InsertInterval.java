package leetCode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 57 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
public class Leet_57_InsertInterval {

    /**
     * 插入的区间newInterval和当前遍历区间curr的关系：
     * 1.区间不重叠。newInterval左边界大于curr右边界或newInterval右边界小于curr左边界。
     * 此时只需保存较小的区间到结果集，再将start和end更新为较大的区间
     * 2.区间重叠，更新start为newInterval[0],curr[0]和start中的较小值，
     * 更新end为newInterval[1],curr[1],end中的较大值
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return null;
        }
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            //区间不重叠,当前区间右边界在newInterval左边，或newInterval右边界在当前区间左边
            if (curr[1] < newInterval[0] || curr[0] > newInterval[1]) {
                //添加curr和newInterval中较小的那个区间，更新start和end为较大的那个区间
                if (curr[0] < newInterval[0]) {
                    result.add(curr);
                    start = newInterval[0];
                    end = newInterval[1];
                } else {
                    result.add(new int[]{start, end});
                    start = curr[0];
                    end = curr[1];
                }
            } else {
                //区间重叠，更新start和end的值;
                start = Math.min(Math.min(curr[0], newInterval[0]), start);
                end = Math.max(Math.max(curr[1], newInterval[1]), end);

            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Leet_57_InsertInterval instance = new Leet_57_InsertInterval();
        int[][] data = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newData = {4,8};
        int[][] result = instance.insert(data, newData);
        for (int[] temp : result) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
