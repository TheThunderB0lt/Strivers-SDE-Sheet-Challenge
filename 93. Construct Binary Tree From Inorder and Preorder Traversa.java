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

public class Solution {
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        return helper(inorder, preorder, 0, inorder.size() - 1, 0, map);
    }

    public static TreeNode<Integer> helper(ArrayList<Integer> inorder,
                                           ArrayList<Integer> preorder, int inStart, int inEnd, int preStart,
                                           HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode<Integer> newNode = new TreeNode<>(preorder.get(preStart));
        int rootIndex = map.get(preorder.get(preStart));
        int leftSubtreeSize = rootIndex - inStart;

        newNode.left = helper(inorder, preorder, inStart, rootIndex - 1, preStart + 1, map);
        newNode.right = helper(inorder, preorder, rootIndex + 1, inEnd, preStart + leftSubtreeSize + 1, map);

        return newNode;
    }
}