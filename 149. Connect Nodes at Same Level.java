import java.util.* ;
import java.io.*; 
/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	if(root == null){
			return;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()){
			int size = q.size();
			for(int i =1;i<=size;i++){
                 BinaryTreeNode<Integer> node = q.poll();
				 if(i != size){
				 node.next = q.peek();
				 }
		          if(node.left != null){
					 q.offer(node.left);
				 }if(node.right != null){
					 q.offer(node.right);
				 }
		     }
		}
		return;
	}
}