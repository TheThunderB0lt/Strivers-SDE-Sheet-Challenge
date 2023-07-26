import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(v<=0){
            return ans;
        }
        s = new Stack<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        boolean visited[] = new boolean[v];
        for(int i =0;i<v;i++){
            if(!visited[i]){
                helper(i, adj, visited);
            }
        }
        while(!s.isEmpty()){
           ans.add(s.pop());
        }
        return ans;
    }
    static Stack<Integer> s;
    public static void helper(int src,ArrayList<ArrayList<Integer>> adj,
    boolean visited[]){
         visited[src] = true;
          for(int e:adj.get(src)){
              if(visited[e] == false){
                  helper(e,adj,visited);
              }
          }
          s.push(src);
    }
}