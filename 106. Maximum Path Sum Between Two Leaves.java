import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

/*  
    Time Complexity : O(N)
    Space Complexity : O(N)

    where 'N' is the number of nodes in the Binary Tree.
*/

class Number{
    long num;
    Number(long num)
    {
        this.num = num;
    }
}

public class Solution {
	public static long findMaxSumPathHelper(TreeNode root, Number maxPathSum) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}
		long maxSumLeftPath = findMaxSumPathHelper(root.left, maxPathSum);
		long maxSumRightPath = findMaxSumPathHelper(root.right, maxPathSum);

		if (root.left != null && root.right != null) {

			maxPathSum.num = Math.max(maxPathSum.num, maxSumLeftPath + maxSumRightPath + root.data);
			return Math.max(maxSumLeftPath, maxSumRightPath) + root.data;

		} else if (root.left == null) {

			return maxSumRightPath + root.data;

		} else {

			return maxSumLeftPath + root.data;

		}
	}

	public static long findMaxSumPath(TreeNode root) {
		// Variable to store the maximum sum of path between two leaves for the given tree.
		Number maxPathSum = new Number(-1L);
		findMaxSumPathHelper(root, maxPathSum);
		return maxPathSum.num;
	}
}