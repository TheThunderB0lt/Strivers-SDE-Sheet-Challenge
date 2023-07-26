import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

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
    static int count = 0;

    public static int kthSmallest(TreeNode<Integer> root, int k) 
    {
        count = 0;
        return kthSmallestHelper(root, k);
    }

    private static int kthSmallestHelper(TreeNode<Integer> root, int k) 
    {
        if (root == null) {
            return -1;
        }

        int left = kthSmallestHelper(root.left, k);
        if (left != -1) {
            return left;
        }

        count++;
        if (count == k) {
            return root.data;
        }

        return kthSmallestHelper(root.right, k);
    }
}