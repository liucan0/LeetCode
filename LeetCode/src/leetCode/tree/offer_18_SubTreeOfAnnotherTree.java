package leetCode.tree;

import base.TreeNode;

/**
 * 描述：<br>
 *     offer:18, leetCode:572
 * 另一棵树的子树。
 * 输入两棵树，判断一棵树是否是另一棵树的子树
 * @ClassName SubTreeOfAnnotherTree
 * @Author liucan
 * @Date 2019/7/18 上午10:28
 * @Version 1.0
 **/
public class offer_18_SubTreeOfAnnotherTree {

	/**
	 * 1.找到是否含有相同结点，
	 * 2.找到结点时判断以该节点为根节点的子树书否相等
	 * 3.子树相等返回true，不相等继续寻找下一个相等的结点直到遍历完s的所有结点
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val == t.val) {
			if (equals(s, t)) {
				return true;
			}
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	/**
	 * 判断两棵树是否相同。
	 * s和t结点相等时，继续判断s.left和t.left,s.right和t.right是否相等
	 * @param s
	 * @param t
	 * @return
	 */
	private boolean equals(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val == t.val) {
			return equals(s.left, t.left) && equals(s.right, t.right);
		}
		return false;
	}
}
