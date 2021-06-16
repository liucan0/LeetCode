package leetCode.tree.medium;

import base.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * leetcode 103 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Leet_103_BinaryZigzagLevelOrderTraversal {

    /**
     * 广度优先遍历。
     * 遍历节点时按照正常中序遍历流程，保存遍历节点值时根据遍历方向决定值的顺序(插入队头或队尾)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean toRight = true;
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        while (!nodesQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodesQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = nodesQueue.poll();
                if (toRight) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }
                if (curr.left != null) {
                    nodesQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nodesQueue.offer(curr.right);
                }
            }
            result.add(new LinkedList<>(levelList));
            toRight = !toRight;
        }
        return result;
    }

    public static void main(String[] args) {
        Leet_103_BinaryZigzagLevelOrderTraversal instance = new Leet_103_BinaryZigzagLevelOrderTraversal();
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = right;
        List<List<Integer>> result = instance.zigzagLevelOrder(root);
        System.out.println(JSON.toJSONString(result));
    }
}
