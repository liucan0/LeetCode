package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 *  根据前序遍历和中序遍历结果重建二叉树
 *  offer:6, leetcode:108
 * @ClassName Offer_6_RebuildTreeFromPreorderAndInOrderTrasversal
 * @Author liucan
 * @Date 2019/8/22 下午4:40
 * @Version 1.0
 **/
public class Offer6_RebuildTreeFromPreorderAndInOrderTrasversal {

	/**
	 *　在前序遍历中，第一个结点一定是根节点，
	 * 在中序遍历中，根结点左边的值都在其左子树中，
	 * 根节点右边的值都在其右子树中。
	 * @param preorder 前序遍历结果
	 * @param inorder  中序遍历结果
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0
				|| inorder == null || inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		if (preorder.length == 1) {
			return root;
		}
		//获取根节点在中序遍历数组的位置
		int rootIndex = 0;
		for (int child : inorder) {
			if (child == preorder[0]) {
				break;
			}
			rootIndex++;
		}
		//获取左子树中序遍历数组
		int[] leftInorder = new int[rootIndex];
		for (int i = 0; i < rootIndex; i++) {
			leftInorder[i] = inorder[i];
		}
		//获取左子树前序遍历数组
		int[] leftPreorder = new int[leftInorder.length];
		for (int i = 0; i < leftInorder.length; i++) {
			leftPreorder[i] = preorder[1 + i];
		}
		//获取右子树中序遍历数组
		int[] rightInorder = new int[inorder.length - rootIndex - 1];
		for (int i = 0; i < rightInorder.length; i++) {
			rightInorder[i] = inorder[i + rootIndex + 1];
		}
		//获取右子树前序遍历数组
		int[] rightPreorder = new int[rightInorder.length];
		for (int i = 0; i < rightInorder.length; i++ ) {
			rightPreorder[i] = preorder[i + leftPreorder.length + 1];
		}
		root.left = buildTree(leftPreorder, leftInorder);
		root.right = buildTree(rightPreorder, rightInorder);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = {3,1,2,4};
		int[] inorder = {1,2,3,4};
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root);

	}
}
