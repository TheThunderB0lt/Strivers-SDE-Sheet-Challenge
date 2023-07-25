import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj1.get(edges[i][0]).add(edges[i][1]);
            adj2.get(edges[i][1]).add(edges[i][0]);
        }
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj1, s);
            }
        }
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!s.isEmpty()) {
            int i = s.pop();
            if (!visited[i]) {
                List<Integer> al = new ArrayList<>();
                dfs2(i, visited, adj2, al);
                ans.add(al);
            }
        }
        return ans;
    }

    public static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj1, Stack<Integer> s) {
        visited[src] = true;
        for (int e : adj1.get(src)) {
            if (!visited[e]) {
                dfs(e, visited, adj1, s);
            }
        }
        s.add(src);
    }

    public static void dfs2(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj1, List<Integer> al) {
        visited[src] = true;
        al.add(src);
        for (int e : adj1.get(src)) {
            if (!visited[e]) {
                dfs2(e, visited, adj1, al);
            }
        }
    }
}