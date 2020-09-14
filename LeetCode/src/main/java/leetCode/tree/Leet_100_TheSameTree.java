package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 *  给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @ClassName TheSameTree
 * @Author liucan
 * @Date 2019/7/15 下午11:13
 * @Version 1.0
 **/
public class Leet_100_TheSameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true  ;
		}
		if(p == null || q == null){
			return false ;
		}
		return p.val == q.val && isSameTree(p.left ,q.left) &&
				isSameTree(p.right ,q.right) ;
	}
}
