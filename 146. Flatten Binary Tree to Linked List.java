import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
       return helper(root);
	 
    }
	public static TreeNode<Integer> helper(TreeNode<Integer> root){
		if(root == null){
		   return null;
	   }
        if(root.left == null&&root.right == null){
			return root;
		}
	   TreeNode<Integer> left = flattenBinaryTree(root.left);
	    TreeNode<Integer> right = flattenBinaryTree(root.right);
         if(left != null){
			 TreeNode<Integer> temp = root.right;
			 root.right = left;
			 TreeNode cur = root.right;
			 while(cur.right != null){
                cur = cur.right;
			 }
			 cur.right = temp;
			 root.left = null;
		 }
		 return root;
	}
}