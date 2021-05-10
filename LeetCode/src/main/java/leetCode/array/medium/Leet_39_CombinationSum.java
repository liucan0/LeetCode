package leetCode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 39 组合总数
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Leet_39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();//已经组合的列表
        Arrays.sort(candidates);//排序输入，用于剪枝提速
        dfs(candidates, target, result, combine, 0);
        return result;
    }

    /**
     * 定义递归函数dfs(target, combine, idx)表示当前在candidates数组的第idx位，
     * 还剩target要组合，已经组合的列表为combine.递归的终止条件为target<=0或者candidates数组被全部用完。
     * 那么在当前数组中，每次我们可以选择跳过不用等第idx个数，即执行dsf(target,combine,idx+1).
     * 也可以选择使用第idx个数，即执行dfs(target-candidates[idx],combine,idx).
     * 注意每个数字可以被无限制重复选取，因此搜索的下标仍为idx。</br></br>
     *
     * 出现重复的原因：在每一个节点做减法展开分支的时候，由于每一个元素可以重复利用，
     * 我们考虑了所有的候选数，因此出现了重复的列表</br></br>
     *
     * 解决：遇到这类相同元素不计算顺序的问题，在搜索的时候就需要按某种顺序搜索。
     * 即每一次搜素的时候设置下一轮搜索的起点。
     * @param candidates 输入数组
     * @param target 还需要组合的目标值
     * @param result 最终返回结果集
     * @param combine 已经组合的列表
     * @param idx 当前在candidates数组的第idx位
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int idx) {
        if (target == 0) {
            //构建新数组保存已知解
            result.add(new ArrayList<>(combine));
            return;//已找到满足需求的数组
        }

        for (int i = idx; i < candidates.length; i++) {
            int diff = target - candidates[i];
            //target减去一个数得到负数，那么减去一个更大的数依然是负数，可以跳过
            //需要输入已升序排序
            if (diff < 0) {
                break;
            }
            combine.add(candidates[i]);
            //由于每一个元素都可以重复使用，下一轮搜索的起点依然是i
            dfs(candidates, diff, result, combine, i);
            //状态重置,去除本次加入的数字,继续往后遍历
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leet_39_CombinationSum instance = new Leet_39_CombinationSum();
        int[] input = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = instance.combinationSum(input, target);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
