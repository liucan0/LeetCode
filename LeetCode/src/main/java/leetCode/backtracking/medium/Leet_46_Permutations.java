package leetCode.backtracking.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 46 全排列
 * 给定一个不含重复数字的数组nums,返回其所有可能的全排列。你可以按任意顺序范湖答案
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Leet_46_Permutations {

    /**
     * 回溯法.
     * 使用boolean数组记录输入数组中每个位置的数字是否已经使用，
     * 回溯时需要同时位置索引和当前值是否使用
     * @param nums 输入数组
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        boolean[] used = new boolean[nums.length];
        backtracking(result, new ArrayList<Integer>(), nums, 0, used);
        return result;
    }

    /**
     *
     * @param result 返回结果集
     * @param temp 当前排列
     * @param nums 输入数组
     * @param index 当前索引
     * @param used 记录数组位置是否已使用
     */
    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int index, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                backtracking(result, temp, nums, index + 1, used);
                used[i] = false;
                temp.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        Leet_46_Permutations instance = new Leet_46_Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(JSON.toJSONString(instance.permute(nums)));
    }
}
