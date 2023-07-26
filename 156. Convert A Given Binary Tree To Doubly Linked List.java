import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
	    head = null;prev = null;
	    return helper(root);
	}
	
	static BinaryTreeNode<Integer> prev =null;
	static BinaryTreeNode<Integer> head =null;
	public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root){
	    if(root == null){
		 return null;
	    }

	   helper(root.left);
		 if(prev == null){
           head = root;
		 }else{
			 root.left  = prev;
			 prev.right = root;
		 }
		 prev = root;
		 helper(root.right);
	    
		return head;
   }
}