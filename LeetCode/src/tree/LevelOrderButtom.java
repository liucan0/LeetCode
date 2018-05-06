package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 * @author liucan
 *
 */
public class LevelOrderButtom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        nodeList.add(new ArrayList<>());
        levelOrderBottom(root, nodeList, 0);
        return nodeList;
    }

    private void levelOrderBottom(TreeNode root, List<List<Integer>> nodeList, int backIndex) {
        if (root == null) {
            return;
        }
        int index = nodeList.size() - backIndex - 1;
        List<Integer> nowList = nodeList.get(index);
        nowList.add(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        if (index == 0) {
            nodeList.add(index, new ArrayList<>());
        }
        levelOrderBottom(root.left, nodeList, backIndex + 1);
        levelOrderBottom(root.right, nodeList, backIndex + 1);
    }
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
		
	}
}
