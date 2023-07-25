import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
import java.util.HashSet;
public class Solution {
    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        HashSet<Integer> complementSet = new HashSet<>();
        return findPairSum(root, k, complementSet);
    }

    private static boolean findPairSum(BinaryTreeNode node, int k, HashSet<Integer> complementSet) {
        if (node == null) {
            return false;
        }

        if (complementSet.contains(node.data)) {
            return true;
        }

        complementSet.add(k - node.data);

        return findPairSum(node.left, k, complementSet) || findPairSum(node.right, k, complementSet);
    }
}








