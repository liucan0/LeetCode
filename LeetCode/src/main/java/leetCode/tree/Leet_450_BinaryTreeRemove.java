package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 * leetCode_450. 删除二叉搜索树中的节点
 * 给出一个二叉树，删除指定结点
 * @ClassName BinaryTreeRemove
 * @Author liucan
 * @Date 2019/7/16 下午10:48
 * @Version 1.0
 **/
public class Leet_450_BinaryTreeRemove {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			// 待删除节点在左子树中
			root.left = deleteNode(root.left, key);
			return root;
		} else if (key > root.val) {
			// 待删除节点在右子树中
			root.right = deleteNode(root.right, key);
			return root;
		} else {
			// key == root.val，root 为待删除节点
			if (root.left == null) {
				// 返回右子树作为新的根
				return root.right;
			} else if (root.right == null) {
				// 返回左子树作为新的根
				return root.left;
			} else {
				// 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
				TreeNode successor = min(root.right);
				successor.right = deleteMin(root.right);
				successor.left = root.left;
				return successor;
			}
		}
	}

	private TreeNode min(TreeNode node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	/**
	 * 删除root结点的最小节点，返回删除结点后的root结点
	 *
	 * @param node
	 * @return
	 */
	private TreeNode deleteMin(TreeNode node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}
}
