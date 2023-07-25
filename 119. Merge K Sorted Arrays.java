import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        // Create a priority queue (min-heap) to store the elements from all arrays
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<kArrays.size();i++){
			for(int j =0;j<kArrays.get(i).size();j++){
				pq.add(kArrays.get(i).get(j));
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		while(!pq.isEmpty()){
			al.add(pq.poll());
		}
		return al;
	}
}