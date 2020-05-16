package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * 二叉树的最小深度
 * @ClassName MinimunDepthOfBinaryTree
 * @Author liucan
 * @Date 2019/7/17 下午5:18
 * @Version 1.0
 **/
public class MinimunDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if (leftDepth > 0 && rightDepth > 0) {
			return 1 + Math.min(leftDepth, rightDepth);
		} else {
			return 1 + Math.min(leftDepth, rightDepth);
		}
	}
}
