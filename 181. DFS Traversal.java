import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (v <= 0) {
            return ans;
        }
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i =0;i<v;i++){
          graph.add(new ArrayList<>());
      }
      for(int i =0;i<e;i++){
       graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
    }
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> al = new ArrayList<>();
                dfs(i, graph, visited, al);
                ans.add(al);
            }
        }
        return ans;
    }
   static  boolean[] visited;
    public static void dfs(int v, ArrayList<ArrayList<Integer>> edges, boolean[] visited, ArrayList<Integer> al) {
        visited[v] = true;
        al.add(v);
        for (int e : edges.get(v)) {
            if (!visited[e]) {
                dfs(e, edges, visited, al);
            }
        }
    }
}