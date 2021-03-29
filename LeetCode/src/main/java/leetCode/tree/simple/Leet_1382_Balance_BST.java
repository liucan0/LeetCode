package leetCode.tree.simple;

import base.TreeNode;

/**
 * 将一颗非平衡二叉树变为平衡二叉树
 */
public class Leet_1382_Balance_BST {

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        return crateBalanceTree(root, null);
    }

    public TreeNode crateBalanceTree(TreeNode root, TreeNode result) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            result = crateBalanceTree(root.left, result);
        }
        if (root.right != null) {
            result = crateBalanceTree(root.right, result);
        }
        result = insert(root.val, result);
        return result;

    }

    public TreeNode insert(int val, TreeNode root) {
        if (root == null) {
            return new TreeNode(val);
        }
        int flag = Integer.compare(val, root.val);
        if (flag > 0) {
            root.right = insert(val, root.right);
        } else if (flag < 0) {
            root.left = insert(val, root.left);
        } else {

        }
        return balance1(root);
    }

    public TreeNode balance1(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (height(root.left) - height(root.right) > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = rotateWithLeftChild(root);
            } else {
                root = doubleWithLeftChild(root);
            }
        } else if (height(root.right) - height(root.left) > 1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = rotateWithRightChild(root);
            } else {
                root = doubleWithRightChild(root);
            }
        }
        return root;
    }

    public TreeNode rotateWithLeftChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        root.left = leftNode.right;
        leftNode.right = root;
        return leftNode;
    }

    public TreeNode rotateWithRightChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightNode = root.right;
        root.right = rightNode.left;
        rightNode.left = root;
        return rightNode;
    }

    public TreeNode doubleWithLeftChild(TreeNode root) {
        root.left = rotateWithRightChild(root.left);
        return rotateWithLeftChild(root);
    }

    public TreeNode doubleWithRightChild(TreeNode root) {
        root.right = rotateWithLeftChild(root.right);
        return rotateWithRightChild(root);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        Leet_1382_Balance_BST tree = new Leet_1382_Balance_BST();
        TreeNode node = new TreeNode(1);
        TreeNode curr = node.right;
        for (int i = 2; i < 5; i++) {
            if (curr != null) {
                curr.right = new TreeNode(i);
                curr = curr.right;
            } else {
                node.right = new TreeNode(i);
                curr = node.right;
            }
        }
        TreeNode result = tree.crateBalanceTree(node, null);
        System.out.println(result);
    }
}
