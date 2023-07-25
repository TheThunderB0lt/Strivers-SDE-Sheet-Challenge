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

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> leftViewList = new ArrayList<>();
        
        if (root == null) {
            return leftViewList;
        }
        
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> current = queue.poll();
                
                // Add the first node of the current level to the left view list
                if (i == 0) {
                    leftViewList.add(current.data);
                }
                
                // Add the left and right children of the current node to the queue
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        
        return leftViewList;
    }
}
