import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
       List<List<Integer>> ans = new ArrayList<>();
	   for(int i =0;i<3;i++){
		   ans.add(new ArrayList<>());
	   }
	   Traveral(root, ans.get(0), ans.get(2), ans.get(1));
	   return ans;
    }

	public static void Traveral(BinaryTreeNode<Integer> root,List<Integer> in,
	List<Integer> post,List<Integer> pre){
		if(root == null){
			return;
		}
          pre.add(root.data);
		 Traveral(root.left, in, post, pre);
		  in.add(root.data);
		  Traveral(root.right, in, post, pre);
		  post.add(root.data);
	}
}