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

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
         TreeNode<Integer> n = lca(root,x,y);
         return n.data;
    }
    public static TreeNode lca(TreeNode<Integer> root,int x,int y){
       if(root == null){
           return null;
       }
        if(root.data==x||root.data==y){
            return root;
        }
        TreeNode<Integer> left = lca(root.left,x,y);
        TreeNode<Integer> right = lca(root.right,x,y);
        if(left!=null &&right !=null){
            return root;
        }else{
            if(left != null){
                return left;
            }else{
                return right;
            }
        }
    }
}