package leetCode.tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：<br>
 * 二叉树层序遍历
 * offer:23, leetCode:102
 *
 * 给定一个二叉树，按层从左往右打印结点.每层打印结果放入一个list中
 * @ClassName offer_23_BinaryTreeLevelOrderTrasversal
 * @Author liucan
 * @Date 2019/7/18 下午5:00
 * @Version 1.0
 **/
public class offer23_BinaryTreeLevelOrderTrasversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		//最后返回的list
		List<List<Integer>> nodeList = new LinkedList<>();
		if (root == null) {
			return nodeList;
		}

		Queue<List<TreeNode>> queue = new LinkedList<>();
		queue.add(new ArrayList<TreeNode>() {
			{
				add(root);
			}
		});
		while (!queue.isEmpty()) {
			//当前层的node容器
			List<TreeNode> levelNodeList = queue.poll();
			List<TreeNode> childNodeList = new ArrayList<>();
			for (TreeNode node : levelNodeList) {
				if (node!= null) {
					if (node.left != null) {
						childNodeList.add(node.left);
					}
					if (node.right != null) {
						childNodeList.add(node.right);
					}
				}
			}
			if (childNodeList.size() > 0) {
				queue.add(childNodeList);
			}
			nodeList.add(nodeToInteger(levelNodeList));
		}
		return nodeList;
	}

	private List<Integer> nodeToInteger(List<TreeNode> nodeList) {
		List<Integer> valueList = new ArrayList<>(nodeList.size());
		for (TreeNode node : nodeList) {
			if (node != null) {
				valueList.add(node.val);
			}
		}
		return valueList;
	}


}
