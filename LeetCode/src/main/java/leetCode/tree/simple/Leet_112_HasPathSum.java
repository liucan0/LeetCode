package leetCode.tree.simple;

import base.TreeNode;

/**
 * leetcode 112 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 * 示例1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 示例2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 */
public class Leet_112_HasPathSum {
    /**
     * 递归 -> 是否存在从当前节点的子节点到叶子节点的路径，满足其路径和为targetSum - root.val
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
