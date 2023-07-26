import java.util.* ;
import java.io.*; 
/************************************************************

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

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
       if(root == null){
           return 0;
       }
       ans = 0;
       helper(root, X);
       return ans;
    }
    static int ans;
    public static void helper(TreeNode<Integer> root, int X){
        if(root == null){
            return;
        }
        if(root.data > X){
            helper(root.left,X);
        }else{
            ans = Math.max(ans,root.data);
            helper(root.right,X);
        }
    }
}