  import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/
public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }
        int differnce = root.data
                - ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0));

        if (differnce > 0) {
            if (root.left != null) {
                root.left.data += differnce;
            }

            else {
                root.right.data += differnce;
            }

        }
        changeTree(root.left);
        changeTree(root.right);

        root.data = ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0));
    }

}