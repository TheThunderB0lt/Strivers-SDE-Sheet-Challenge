import java.util.* ;
import java.io.*; 
/*************************************************************************

    Following is the class structure of the Node class:

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

*************************************************************************/

public class Solution {
    static class BSTInfo {
        int size;
        int min;
        int max;

        BSTInfo(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int largestBST(TreeNode<Integer> root) {
       ans = 0;
	    BSTInfo bstInfo = findLargestBST(root);
        return ans;
    }
   
   static int ans;
    private static BSTInfo findLargestBST(TreeNode<Integer> node) {
        if (node == null) {
            return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTInfo leftInfo = findLargestBST(node.left);
        BSTInfo rightInfo = findLargestBST(node.right);

        if (leftInfo.size == -1 || rightInfo.size == -1 || node.data <= leftInfo.max || node.data >= rightInfo.min) {
            return new BSTInfo(-1, 0, 0);
        }

        int size = leftInfo.size + rightInfo.size + 1;
        int min = (node.left != null) ? leftInfo.min : node.data;
        int max = (node.right != null) ? rightInfo.max : node.data;
         ans = Math.max(size,ans);
        return new BSTInfo(size, min, max);
    }
}