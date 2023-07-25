/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
      if(root == null){
          return true;
      }
       return isSymmetricHelper(root,root);
    }
    public static boolean isSymmetricHelper(BinaryTreeNode<Integer> root1,
    BinaryTreeNode<Integer> root2){
     if(root1 == null && root2 == null){
        return true;
     }
     if(root1 == null&&root2!=null||root2 == null&&root1 != null){
         return false;
     }
  if (!root1.data.equals(root2.data)) {
            return false;
        }
     return  isSymmetricHelper(root1.left,root2.right)&&
      isSymmetricHelper(root1.right,root2.left);
    
    }
}