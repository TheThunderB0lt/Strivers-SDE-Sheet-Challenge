import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
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

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root != null) {
            result.add(root.data);

            // Traverse left boundary excluding leaf node
            traverseLeftBoundary(root.left, result);

            // Traverse leaf nodes in left-to-right order
            traverseLeaves(root.left, result);
            traverseLeaves(root.right, result);

            // Traverse right boundary excluding leaf node
            traverseRightBoundary(root.right, result);
        }

        return result;
    }

    private static void traverseLeftBoundary(TreeNode node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        result.add(node.data);

        if (node.left != null)
            traverseLeftBoundary(node.left, result);
        else
            traverseLeftBoundary(node.right, result);
    }

    private static void traverseRightBoundary(TreeNode node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        if (node.right != null)
            traverseRightBoundary(node.right, result);
        else
            traverseRightBoundary(node.left, result);

        result.add(node.data);
    }

    private static void traverseLeaves(TreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;

        traverseLeaves(node.left, result);

        if (node.left == null && node.right == null)
            result.add(node.data);

        traverseLeaves(node.right, result);
    }
}