import java.util.* ;

public class Solution {
    
    static class Pair implements Comparable<Pair> {
        int adjnode;
        int wt;
        int parent;
        public Pair(int adjnode, int wt,int parent) {
            this.adjnode = adjnode;
            this.wt = wt;
            this.parent = parent;
        }
        
        public int compareTo(Pair p) {
            return this.wt - p.wt;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int wt = g.get(i).get(2);
            
            adj.get(u).add(new Pair(v, wt,u));
            adj.get(v).add(new Pair(u, wt,v));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        
        pq.add(new Pair(1,0,-1));
        
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            
            if (visited[p.adjnode]) {
                continue;
            }
            
            visited[p.adjnode] = true;
            int node = p.adjnode;
            int wt = p.wt;
            int parent = p.parent;
            if(parent != -1){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(node);
            al.add(parent);
            al.add(wt);
            ans.add(al);
            }
            for (Pair e : adj.get(node)) {
                int adjnode = e.adjnode;
                int adjwt = e.wt;
                
                if (!visited[adjnode]) {
                    pq.add(new Pair(adjnode, adjwt,node));
                }
            }
        }    
        return ans;
    }
    
}