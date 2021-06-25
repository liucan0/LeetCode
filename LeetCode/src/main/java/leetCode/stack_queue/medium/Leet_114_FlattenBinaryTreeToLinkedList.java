package leetCode.stack_queue.medium;


import base.TreeNode;

/**
 * leetcode 114 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 */
public class Leet_114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        flattenTreeNode(root);
    }

    private TreeNode flattenTreeNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        //暂存右子树
        TreeNode right = root.right;
        //左子树伸展为右子树
        root.right = flattenTreeNode(root.left);
        //剪掉左子树
        root.left = null;
        //对暂存的右子树进行伸展
        right = flattenTreeNode(right);
        //将伸展后的右子树接到root叶子节点
        TreeNode curr = root;
        if (curr != null) {
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        right.right = new TreeNode(6);
        root.left = left;
        root.right = right;
        Leet_114_FlattenBinaryTreeToLinkedList instance = new Leet_114_FlattenBinaryTreeToLinkedList();
        instance.flatten(root);
        System.out.println(root);
    }
}
