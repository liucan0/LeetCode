package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * 二叉树的最大深度。
 * 输入一个二叉树，给出它的最大深度
 * @ClassName MaxDeepthOfBinaryTree
 * @Author liucan
 * @Date 2019/7/16 上午10:32
 * @Version 1.0
 **/
public class Leet_104_MaxDeepthOfBinaryTree {
	int deepth = 0;
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
