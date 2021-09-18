package leetCode.backtracking.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Leet_77_Combine {

    /**
     * 回溯法。思路参考46、47全排列
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, new ArrayList<>(), n, 0, k);
        return result;
    }

    private void recursion(List<List<Integer>> result, List<Integer> temp, int n, int index, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        /*
        因为是枚举组合，不是元素的全排列，只需遍历当前位置以后的元素，
        所以从index下表开始遍历。因为不含重复元素，所以也不需要剪枝
         */
        for (int i = index; i < n; i++) {
            temp.add(i + 1);
            recursion(result, temp, n, i + 1, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leet_77_Combine instance = new Leet_77_Combine();
        System.out.println(JSON.toJSONString(instance.combine(4, 2)));
    }
}
