package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * 镜像二叉树。
 * 输入两个二叉树，判断他们是否是镜像对称
 * @ClassName SymmetricTree
 * @Author liucan
 * @Date 2019/7/16 上午10:21
 * @Version 1.0
 **/

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		return leftNode.val == rightNode.val && isSymmetric(leftNode.left, rightNode.right)
				&& isSymmetric(leftNode.right, rightNode.left);
	}
}
