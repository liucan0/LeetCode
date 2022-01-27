package leetCode.backtracking.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * leetcode 78 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Leet_78_Subsets {

    /**
     * 方法1：逐个枚举。
     * 空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合都追加这个元素，
     * 就是新增的子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }


    List<Integer> t = new ArrayList<>();//存放已被选出的数字
    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 方法2：回溯法(递归)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * 深度优先搜索
     * 原序列的每个位置在答案序列中的状态有被选中和不被选中两种状态，
     * 我们用t数组存放已经被选出的数字，n表示数组长度。在进入dfs(curr,n)之前，数组中[0,curr-1]位置的状态是确定的，
     * 而[curr,n-1]位置的状态是不确定的，dfs(curr,n)需要确定curr位置的状态，然后求解子问题dfs(curr+1,n).
     * 对于curr位置，我们需要考虑nuns[curr]取或是不取，如果取，我们需要把nunms[curr]放入一个临时数组t，
     * 再执行dfs(curr+1,n)，执行结束后需要对t进行回溯；如果不取，则直接执行dfs(curr+1,n).
     * 在整个递归调用的过程中，curr是从小到大递增的，当curr增加到n的是时候，记录答案并终止递归。
     * @param curr 当前数组位置
     * @param nums 输入数组
     */
    public void dfs(int curr, int[] nums) {

        if (curr == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            System.out.println(t);
            return;
        }
        t.add(nums[curr]);
        dfs(curr + 1, nums);
        t.remove(t.size() - 1);
        dfs(curr + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Leet_78_Subsets instance = new Leet_78_Subsets();
        List<List<Integer>> result = instance.subsets2(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
