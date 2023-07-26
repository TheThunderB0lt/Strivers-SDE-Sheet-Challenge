import java.util.ArrayList;

public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int j = 0;
        while (j < m) {
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
            j++;
        }
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <=n; i++) {
            if (!visited[i]) {
                if (checkCycle(i, 0, adj, visited)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
    
      public static boolean checkCycle(int src,int parent,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
      visited[src] = true;
      for(int e:adj.get(src)){
          if(!visited[e]){
              if(checkCycle(e,src,adj,visited)){
                  return true;
              }
          }else if(e!=parent){
              return true;
          }
      }
      return false;
  }
}