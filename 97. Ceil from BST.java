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

    public  static int findCeil(TreeNode<Integer> node, int x) {
      ans = Integer.MAX_VALUE;
      helper(node, x);
      if(ans == Integer.MAX_VALUE){
          return -1;
      }
      return ans;
    }
    static int ans;
    public static void helper(TreeNode<Integer> node, int x){
        if(node == null){
            return;
        }
        if(node.data == x){
            ans = node.data;
            return;
        }
        if(node.data>x){
            ans = Math.min(ans,node.data);
            helper(node.left,x);
        }else{
            helper(node.right,x);
        }
    }
}