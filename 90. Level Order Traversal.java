import java.util.* ;
import java.io.*; 
/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
      ArrayList<Integer> ans = new ArrayList<>();
	   if(root == null){
		   return ans;
	   }
	   Queue<BinaryTreeNode> q = new LinkedList<>();
	   q.offer(root);
	   while (!q.isEmpty()) {
            int size = q.size();
        for (int i = 0; i < size; i++) {
        BinaryTreeNode node = q.poll();
		ans.add(node.val);
        if (node.left != null) {
            q.offer(node.left);
        }
        if (node.right != null) {
            q.offer(node.right);
         }
       }
    }
return ans;
  }

}