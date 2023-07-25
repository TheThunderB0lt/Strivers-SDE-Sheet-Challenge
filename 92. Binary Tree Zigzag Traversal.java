import java.util.* ;
import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<BinaryTreeNode<Integer>> currentLevel = new Stack<>();
        Stack<BinaryTreeNode<Integer>> nextLevel = new Stack<>();
        boolean leftToRight = true;

        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            BinaryTreeNode<Integer> node = currentLevel.pop();
            ans.add(node.data);

            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode<Integer>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        return ans;
    }
}
