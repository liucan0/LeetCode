package leetCode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 56 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Leet_56_MergeIntervals {

    /**
     * 首先将列表中的区间按照左端点升序排序，将第一个区间加入到结果数组中，并按顺序依次考虑之后的每个区间：
     * 如果当前区间左端点在end之后，那么他们不会重合，可以直接将这个区间加入数组；
     * 否则他们重合，需要用当前区间的右断电更新数组中最后一个区间的右端点，将其置为二者较大值
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        //重点！排序保证区间升序排列
        Arrays.sort(intervals, (val1, val2) -> val1[0] - val2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        int length = intervals.length;
        for (int i = 1; i < length; i++) {
            int[] temp = intervals[i];
            //当前区间左端点在上一个区间内，更新当前区间右端点
            if (temp[0] <= end) {
                end = Math.max(end, temp[1]);
            } else {
                //抢钱区间左端点在上一区间右端点外， 区间不重合，保存上一区间。重置start,end
                result.add(new int[]{start, end});
                start = temp[0];
                end = temp[1];
            }
        }
        //保存合并后的最后一个区间
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Leet_56_MergeIntervals instance = new Leet_56_MergeIntervals();
        int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        data = new int[][]{{1,4},{0,0}};
        int[][] result = instance.merge(data);
        for (int[] temp : result) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
