import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
       return helper(arr, 0,n-1);
    }

    public static TreeNode<Integer> helper(ArrayList<Integer> arr,int l,int h){
        if(l>h){
            return null;
        }
        int mid = (l+h)/2;
        TreeNode<Integer> newnode = new TreeNode<>(arr.get(mid));
        if(l==h){
          return newnode;
        }
        newnode.left = helper(arr, l, mid-1);
        newnode.right = helper(arr,mid+1,h);
        return newnode;
    }
}