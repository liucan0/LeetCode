package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * 二叉搜索树中插入新节点
 * @ClassName BinaryTreeInsert
 * @Author liucan
 * @Date 2019/7/16 下午4:04
 * @Version 1.0
 **/

public class BinaryTreeInsert {

	public TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val < val) {
			root.left = insert(root.left, val);
		} else if (root.val > val) {
			root.right = insert(root.right, val);
		} else {

		}
		return root;
	}
}
