package leetCode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 40 组合总数2
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Leet_40_CombinationSum_Two {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        dsf(candidates, target, result, combine, 0);
        return result;
    }

    private void dsf(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }

        for (int i = idx; i < candidates.length;) {
            int diff = target - candidates[i];
            if (diff < 0) {
                break;
            }
            combine.add(candidates[i]);
            dsf(candidates, diff, result, combine, i + 1);
            combine.remove(combine.size() - 1);
            int nextIdx = getNextIndex(candidates, i);
            if (candidates[i] != candidates[nextIdx]) {
                i = nextIdx;
            } else {
                break;
            }
        }
    }

    private int getNextIndex(int[] candidates, int idx) {
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[idx] != candidates[i]) {
                return i;
            }
        }
        return idx == candidates.length - 1 ? idx : idx + 1;
    }

    public static void main(String[] args) {
        Leet_40_CombinationSum_Two instance = new Leet_40_CombinationSum_Two();
        int[] input = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = instance.combinationSum2(input, target);
        for (List<Integer> temp : result) {
            System.out.println(Arrays.toString(temp.toArray()));
        }
    }
}
