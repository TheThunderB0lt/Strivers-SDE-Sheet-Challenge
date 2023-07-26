import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int j = 0;
        while (j <edges.size()) {
            adj.get(edges.get(j).get(0)).add(edges.get(j).get(1));
           // adj.get(edges.get(j).get(1)).add(edges.get(j).get(0));
            j++;
        }
        boolean visited[] = new boolean[n + 1];
         boolean path[] = new boolean[n + 1];
        for (int i = 1; i <=n; i++) {
            if (!visited[i]) {
                if (checkCycle(i,adj, visited,path)) {
                    return true;
                }
            }
        }
        return false;
  }

     public static boolean checkCycle(int src,ArrayList<ArrayList<Integer>> adj,
     boolean visited[],boolean path[]){
      visited[src] = true;
      path[src] = true;
      for(int e:adj.get(src)){
          if(!visited[e]){
              if(checkCycle(e,adj,visited,path)){
                  return true;
              }
          }else if(path[e] ==true){
              return true;
          }
      }
      path[src] = false;
      return false;
  }
}