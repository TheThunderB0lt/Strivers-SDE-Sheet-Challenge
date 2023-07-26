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

public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
          if (root == null)
            return new ArrayList<Integer>();
 

        HashMap<Integer, ArrayList<Integer> > m
            = new HashMap<>();
        int hd = 0;
 
    
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(root, hd));
 
        int mn = 0, mx = 0;
        while (q.size() > 0) {
 
            pair temp = q.remove();
 
            hd = temp.second;
           TreeNode<Integer> node = temp.first;
 
            if (!m.containsKey(hd))
                m.put(hd, new ArrayList<>());
                 m.get(hd).add(node.data);
            
            if(node.left != null)
                q.add(new pair(node.left, hd - 1));
            if (node.right != null)
                q.add(new pair(node.right, hd + 1));
 
            // Update mn and mx
            if (mn > hd)
                mn = hd;
            else if (mx < hd)
                mx = hd;
        }
        ArrayList<Integer> ans = new ArrayList<>();
         for (int i = mn; i <= mx; i++) {
            ArrayList<Integer> tmp = m.get(i);
            for (int j = 0; j < tmp.size(); j++){
                ans.add(tmp.get(j));
            }
        }
        return ans;
    }
static class pair {
        TreeNode<Integer> first;
        int second;
       public pair( TreeNode<Integer> first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
}