import java.util.* ;
import java.io.*; 
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int e:arr){
			if(map.containsKey(e)){
				map.put(e, map.get(e)+1);
			}else{
				map.put(e, 1);
			}
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue()
				 : a.getKey() - b.getKey());
        
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;

	}

}