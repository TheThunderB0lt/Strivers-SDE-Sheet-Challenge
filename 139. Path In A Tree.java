import java.util.* ;


import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
       ArrayList<Integer> ans = new ArrayList<>();
      
      if(root == null){
          return ans;
      }
      hasPath(root, ans,x);
       return ans;
    }
    public static boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x)
    {
        // if root is NULL
        // there is no path
        if (root==null)
            return false;
       
        // push the node's value in 'arr'
        arr.add(root.data);    
       
        // if it is the required node
        // return true
        if (root.data == x)    
            return true;
       
        // else check whether the required node lies
        // in the left subtree or right subtree of 
        // the current node
        if (hasPath(root.left, arr, x) ||
            hasPath(root.right, arr, x))
            return true;
       
        // required node does not lie either in the 
        // left or right subtree of the current node
        // Thus, remove current node's value from 
        // 'arr'and then return false    
        arr.remove(arr.size()-1);
        return false;            
    }
 
}