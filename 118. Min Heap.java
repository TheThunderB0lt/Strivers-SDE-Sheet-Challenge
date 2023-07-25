import java.util.* ;
import java.io.*; 

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
      ArrayList<Integer> al = new ArrayList();
       for(int i =0;i<n;i++){
         if(q[i].length>1){
             pq.add(q[i][1]);
         }else{
            al.add(pq.remove());
         }
       }
       int a[] = new int[al.size()];
       for(int i =0;i<al.size();i++){
         a[i] = al.get(i);
       }
       return a;
    }
}