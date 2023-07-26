import java.util.* ;
import java.io.*; 
/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution {

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return null;
        }
        if (p.data < root.data && q.data < root.data) {
            return LCAinaBST(root.left, p, q);
        } 
        if (p.data > root.data && q.data > root.data) {
            return LCAinaBST(root.right, p, q);
        }
        return root;
    }
}





