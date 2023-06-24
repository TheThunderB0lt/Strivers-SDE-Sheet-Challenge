import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		// Brute : TC :O(N^2) SC: O(1)
		// for(int i = 0; i < n; i++){
		// 	int cnt = 0;
		// 	for(int j = 0; j < n; j++){
		// 		if(arr[i] == arr[j]) cnt++;

		// 	}
		// 	if(cnt > n/2){
		// 		return arr[i];
		// 	}
		// }
		// return -1;

		// Better : TC & SC : O(N) 
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < n; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for(HashMap.Entry<Integer, Integer> mp : map.entrySet()){
			if(mp.getValue() > (n / 2)) return mp.getKey();
		}
		return -1;
	}
}