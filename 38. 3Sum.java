import java.util.* ;
import java.io.*;
import java.util.ArrayList; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int target)  {
	    // Write your code here.
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);

		for(int i = 0; i < n; i++) {
			if(i > 0 && arr[i] == arr[i-1]) continue;
			int j = i+1;
			int k = n-1;

			while(j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if(sum < target) j++;
				else if(sum > target) k--;
				else {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(arr[i]);
					temp.add(arr[j]);
					temp.add(arr[k]);
					res.add(temp);
					j++;
					k--;
					while(j < k && arr[j] == arr[j-1]) j++;
					while(j < k && arr[k] == arr[k+1]) k--;
				} 
			}
		}
		return res;
	}
}
