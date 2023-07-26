import java.util.*;

public class Solution {
    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        return checkHeightAndBalance(root) != -1;
    }

    public static int checkHeightAndBalance(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeightAndBalance(root.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }

        int rightHeight = checkHeightAndBalance(root.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Tree is unbalanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the current node
    }
}