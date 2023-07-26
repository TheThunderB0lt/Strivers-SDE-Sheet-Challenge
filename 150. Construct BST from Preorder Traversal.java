import java.util.* ;
import java.io.*; 
 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 	    i =0;
		  return helper(preOrder,Integer.MAX_VALUE);
	}
    static int i =0;
	public static TreeNode<Integer> helper(int pre[],int ub){
		if(i==pre.length){
			return null;
		}
		if(pre[i]>ub){
			return null;
		}
		TreeNode<Integer> newnode = new TreeNode<>(pre[i]);
		i++;
		newnode.left = helper(pre,newnode.data);
		newnode.right = helper(pre,ub);
		return newnode;
	}
}