package leetCode.tree;
/*
 * 计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class SumOfLeftLeaves {

	private int sum = 0;
	
    public int sumOfLeftLeaves(TreeNode root) {
        if(root != null){
            sum(root);
            return sum;
        } else {
            return 0;
        }
        
    }
    public void sum(TreeNode root){
        if(root.left != null){
            sum(root.left);
            if(root.left.left == null && root.left.right == null){
                 sum += root.left.val;
            }
           
        }
        if(root.right != null){
            sum(root.right);
        }
    }
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
}
