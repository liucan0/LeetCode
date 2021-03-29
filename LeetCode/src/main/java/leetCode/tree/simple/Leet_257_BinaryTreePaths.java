package leetCode.tree.simple;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Leet_257_BinaryTreePaths {

    /**
     * 深度优先搜索
     * 1.如果当前节点不是叶子节点，则在当前节点的路径末尾添加该节点，
     * 并继续递归遍历该节点的每一个孩子节点
     * 2.如果当前节点是叶子节点，则在当前路径末尾添加该节点后就得到了一条从
     * 根节点到该叶子节点的路径，将该路径加入到答案
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

}
