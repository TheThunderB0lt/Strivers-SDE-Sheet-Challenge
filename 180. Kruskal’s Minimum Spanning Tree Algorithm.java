import java.util.* ;
import java.io.*; 
public class Solution {

    public static class DSU{
        int size[];
        int parent[];
        public DSU(int v){
            size = new int[v];
            parent = new int[v];
            for(int i =0;i<v;i++){
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            int ultimateParent = findParent(parent[node]);
            parent[node] = ultimateParent;
            return ultimateParent;
        }

        public void union(int a,int b){
            if(findParent(a) == findParent(b)){
                return;
            }
            int parenta = findParent(a);
            int parentb = findParent(b);
            if(size[parenta]<size[parentb]){
                parent[parenta] = parentb;
                size[parentb] = size[parentb]+size[parenta];
            }else{
                parent[parentb] = parenta;
                size[parenta] = size[parentb]+size[parenta];
            }
        }
    }
    public static class pair implements Comparable<pair>{
        int node;
        int adjnode;
        int wt;
        public pair(int node, int adjnode,int wt){
            this.node = node;
            this.adjnode = adjnode;
            this.wt = wt;
        }

        public int compareTo(pair p){
            return this.wt -p.wt;
        }
    }
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<pair> adj = new ArrayList<>();
        for(int i =0;i<m;i++){
            int node = graph.get(i).get(0);
            int adjnode = graph.get(i).get(1);
            int wt = graph.get(i).get(2);
            adj.add(new pair(node, adjnode, wt));
        }
        DSU dsu = new DSU(n+1);
        Collections.sort(adj);
        int ans = 0;
        for(int i =0;i<adj.size();i++){
            pair p = adj.get(i);
            if(dsu.findParent(p.node) != dsu.findParent(p.adjnode)){
                dsu.union(p.node,p.adjnode);
                ans = ans+p.wt;
            }
        } 
        return ans;
    }
}