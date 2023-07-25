import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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


public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root)
    {
        if(root == null) {
    		 return "x"+",";
    	 }
    	 String key = Integer.toString(root.data);
    	 String l = serializeTree(root.left);
    	 String r = serializeTree(root.right);
    	 return key+","+l+r;
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
        Queue<String> queue = new LinkedList<>();
    	String[] a = str.split(",");
    	queue.addAll(Arrays.asList(a));
    	 return helper(queue);
    }

     public static TreeNode<Integer> helper(Queue<String> s) {
    	 String data = s.poll();
    	 if(data.equals("x")) {
    		 return null;
    	 }
    	 TreeNode<Integer> newnode = new TreeNode<Integer>(Integer.valueOf(data));
    	 newnode.left = helper(s);
    	 newnode.right = helper(s);
    	 return newnode; 
     }
}