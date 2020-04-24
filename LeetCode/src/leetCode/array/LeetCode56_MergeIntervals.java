package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 描述：<br>
 * leetcode 56,给出一个区间的集合，请合并所有重叠的区间。
 * 例：输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @ClassName LeetCode56_MergeIntervals
 * @Author liucan
 * @Date 2020/4/16 下午10:08
 * @Version 1.0
 **/
public class LeetCode56_MergeIntervals {

	//题解
	public static int[][] mergeStand(int[][] intervals) {
		int len = intervals.length;
		if (len < 2) {
			return intervals;
		}

		// 按照起点排序
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		// 也可以使用 Stack，因为我们只关心结果集的最后一个区间
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);

		for (int i = 1; i < len; i++) {
			int[] curInterval = intervals[i];
			// 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
			int[] peek = res.get(res.size() - 1);

			if (curInterval[0] > peek[1]) {
				res.add(curInterval);
			} else {
				// 注意，这里应该取最大
				peek[1] = Math.max(curInterval[1], peek[1]);
			}
		}
		return res.toArray(new int[res.size()][]);
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return intervals;
		}
		int[][] result = new int[intervals.length][];
		int resutlIndex = 0;
		int start = intervals[0][0];
		int end = intervals[0][intervals[0].length - 1];
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (end >= curr[0] && end < curr[curr.length - 1]) {
				end = curr[curr.length - 1];
				if (i == intervals.length - 1) {
					end = curr[curr.length - 1];
					result[resutlIndex++] = new int[]{start, end};
				}
			} else {
				result[resutlIndex++] = new int[]{start, end};
				start = curr[0];
				end = curr[curr.length - 1];
				if (i == intervals.length - 1) {
					start = curr[0];
					end = curr[curr.length - 1];
					result[resutlIndex++] = new int[]{start, end};
				}
			}
		}
		int[][] result1 = new int[resutlIndex][];
		for (int i = 0; i < result.length; i++) {
			if (result[i] != null) {
				result1[i] = result[i];
			}
		}
		return result1;
	}

	public static void main(String[] args) {
		int[][] data = {{1,3},{2,6},{8,10},{15,18}};
		int[][] data1 = {{1,3},{3,6}};
		int[][] result = merge(data1);
		System.out.println(result);
	}
}
