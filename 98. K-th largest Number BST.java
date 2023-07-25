import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		ans = -1;
		count = 0;
		helper(root,k);
		return ans;
	}
	static int ans;
   static int count =0;
	public static void helper(TreeNode<Integer> root, int k){
		if(root == null){
			return;
		}
		helper(root.right,k);
		count++;
		if(count == k){
			ans = root.data;
		}
		helper(root.left,k);

	}
}