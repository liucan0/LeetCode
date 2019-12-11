package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * 翻转二叉树
 * offer:19, leetCode:226
 * @ClassName offer_19_InvertBinaryTree
 * @Author liucan
 * @Date 2019/7/18 下午4:25
 * @Version 1.0
 **/
public class offer19_InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		if (root.left != null || root.right != null) {
			TreeNode left = root.left;
			root.left = root.right;
			root.right = left;
		}
		return root;


	}
}
