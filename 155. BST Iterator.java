import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
public class Solution {

    static class BSTIterator {

        private Stack<TreeNode<Integer>> stack;

        BSTIterator(TreeNode<Integer> root) {
            stack = new Stack<>();
            pushLeftChildren(root);
        }

        int next() {
            TreeNode<Integer> current = stack.pop();
            pushLeftChildren(current.right);
            return current.data;
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeftChildren(TreeNode<Integer> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/