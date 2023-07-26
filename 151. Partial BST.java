import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(BinaryTreeNode<Integer> root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.data < lowerBound || root.data > upperBound) {
            return false;
        }

        return helper(root.left, lowerBound, root.data) && helper(root.right, root.data, upperBound);
    }

}