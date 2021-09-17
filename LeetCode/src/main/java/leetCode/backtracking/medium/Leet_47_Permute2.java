package leetCode.backtracking.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47 全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Leet_47_Permute2 {

    /**
     * 回溯法。思路同46题不含重复数字的全排列。由于包含重复元素，需要进行剪枝
     * 剪枝：为解决遍历重复绳子生成的重复排列，首先需要对输入数组进行排序，
     * 然后需要保证重复数字只会被遍历一次，
     * 即每次填入的数一定是这个数所在重复数集合中从左往右第一个未被使用过的数字
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        Arrays.sort(nums);
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
            //剪枝，遇到重复数字时，只遍历相同数字的从左往右第一个未被使用的数字
            //如果当前数字与前一个数字相同，而前一个数字未被使用，在index+1轮遍历中一定会重复，所以需要剪去
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                //当前数字已被使用或(当前数字与前一个数字相同并且前一个数字未被使用)时跳过
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            backtracking(result, temp, nums, index + 1, used);
            used[i] = false;
            temp.remove(index);
        }
    }

    public static void main(String[] args) {
        Leet_47_Permute2 instance = new Leet_47_Permute2();
        int[] nums = {1, 1, 2};
        System.out.println(JSON.toJSONString(instance.permuteUnique(nums)));
        int[] nums1 = {1, 2, 3};
        System.out.println(JSON.toJSONString(instance.permuteUnique(nums1)));
    }
}
