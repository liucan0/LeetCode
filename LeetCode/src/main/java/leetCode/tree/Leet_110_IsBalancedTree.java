package leetCode.tree;

import base.TreeNode;

/**
 * leetcode 110 判断是否是平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Leet_110_IsBalancedTree {
    /**
     * 不光要判断左右子树的高度差绝对值是否超过1，还要判断左右子树是否平衡
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);

        Leet_110_IsBalancedTree instance = new Leet_110_IsBalancedTree();
        System.out.println(instance.isBalanced(node));
    }
}
