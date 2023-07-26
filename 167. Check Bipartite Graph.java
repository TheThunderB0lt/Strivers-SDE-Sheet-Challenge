import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<edges.size();i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.size();i++){
            for(int j =0;j<edges.get(i).size();j++){
                if(edges.get(i).get(j) == 1){
                    adj.get(i).add(j);
                       adj.get(j).add(i);
                }
            }
        }
        int visited[] = new int[edges.size()];
       for(int i =0;i<edges.size();i++){
           if(visited[i] == 0){
             if(helper(i, visited, adj)==false){
                 return false;
             }
           }
       }
       return true;
    }

     public static boolean helper(int src,int visited[],
     ArrayList<ArrayList<Integer>> adj)
     {
         visited[src] = 1;
         Queue<Integer> q = new LinkedList<>();
         q.offer(src);
         while(!q.isEmpty()){
             int node = q.poll();
             int nodecolor = visited[node];
             for(int e:adj.get(node)){
                if(visited[e] == 0){
                 if(nodecolor == 1){
                     visited[e] = 2;
                 }else{
                     visited[e] = 1;
                 }
                 q.offer(e);
             }else{
                 if(nodecolor == visited[e]){
                     return false;
                 }
             }
         }
         }
         return true;
     }
}