package leetCode.tree;

import base.TreeNode;

import java.util.*;

/**
 * 描述:<br>
 * leetcode107 二叉树层序遍历(由下往上)
 * @ClassName Leet_107_levelOrderBottom
 * @Author liucan
 * @Date 2020/9/15 下午6:35
 * @Version 1.0.0
 */
public class Leet_107_levelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> result = new Stack<>();
        if (root == null) {
            return result;
        }
        Queue<List<TreeNode>> nodeQueue = new LinkedList<>();
        nodeQueue.add(new ArrayList<TreeNode>(){
            {
                add(root);
            }
        });
        while (!nodeQueue.isEmpty()) {
            List<TreeNode> levelNodes = nodeQueue.poll();
            List<TreeNode> childrenNodes = new ArrayList<>();
            for (TreeNode node : levelNodes) {
                if (node.left != null) {
                    childrenNodes.add(node.left);
                }
                if (node.right != null) {
                    childrenNodes.add(node.right);
                }
            }
            if (childrenNodes.size() > 0) {
                nodeQueue.add(childrenNodes);
            }
            result.add(toInteger(levelNodes));
        }
        List<List<Integer>> result1 = new ArrayList<>();
        while (!result.empty()) {
            result1.add(result.pop());
        }
        return result1;
    }

    private List<Integer> toInteger(List<TreeNode> nodeList) {
        List<Integer> result = new ArrayList<>();
        for (TreeNode node : nodeList) {
            result.add(node.val);
        }
        return result;
    }
}
