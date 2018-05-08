package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序,中序,后序遍历.
 * 遍历的时间复杂度为O(n),因为每个节点只会被访问一次
 * @author liucan
 *
 */
public class BinaryTreeTraverse<E> {
	
	private TreeNode<E> root;//根节点
	private List<TreeNode<E>> list = new ArrayList<TreeNode<E>>();//遍历结果保存到list
	
	public BinaryTreeTraverse() {
		initTree();
	}
	//初始化树
	public void initTree(){
		TreeNode<String> x=new TreeNode<String>("X",null,null);
		TreeNode<String> y=new TreeNode<String>("Y",null,null);
		TreeNode<String> d=new TreeNode<String>("d",x,y);
		TreeNode<String> e=new TreeNode<String>("e",null,null);
		TreeNode<String> f=new TreeNode<String>("f",null,null);
		TreeNode<String> c=new TreeNode<String>("c",e,f);
		TreeNode<String> b=new TreeNode<String>("b",d,null);
		TreeNode<String> a=new TreeNode<String>("a",b,c);
        root =(BinaryTreeTraverse<E>.TreeNode<E>) a;
	}
	//定义节点类
	private class TreeNode<E>{
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;
		protected TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	//前序遍历,先处理当前节点,再处理左右子树
	public void preorder(TreeNode<E> node){
		list.add(node);
		if(node.left != null){
			preorder(node.left);
		}
		if(node.right != null){
			preorder(node.right);
		}
	}
	
	//中序遍历,先处理左子树,再处理当前节点 ,最后处理右子树
	public void inorder(TreeNode<E> node){
		if(node.left != null){
			inorder(node.left);
		}
		list.add(node);
		if(node.right != null){
			inorder(node.right);
		}
	}
	
	//后序遍历,先处理左右子树,再处理当前节点
	public void postorder(TreeNode<E> node){
		if(node.left != null){
			postorder(node.left);
		}
		if(node.right != null){
			postorder(node.right);
		}
		list.add(node);
	}
	
	//返回当前节点的深度
	public int depth(TreeNode<E> node){
		if(node == null){
			return -1;
		} else {
			return 1 + Math.max(depth(node.left),depth(node.right));
		}
	}
	
	
}
