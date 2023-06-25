import java.io.*;
import java.util.* ;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		// Write your code here.
		int cnt = 0;
		int sum = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		for (int i = 0; i < arr.size(); i++){
			sum += arr.get(i);
			
			if(map.containsKey(sum)){
				int idx = map.get(sum);
				cnt = Math.max(cnt, i - idx);
			} else {
				map.put(sum, i);
			}
		}
		
		return cnt;
	}
}
