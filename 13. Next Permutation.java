import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
		int idx = -1;

		for(int i = n-2; i >= 0; i--){
			if(nums.get(i) < nums.get(i+1)){
				idx = i;
				break;
			}
		}

		if(idx == -1){
			Collections.reverse(nums);
			return nums;
		}

		for(int i = n-1; i >= idx; i--){
			if(nums.get(i) > nums.get(idx)){
				int temp = nums.get(i);
				nums.set(i, nums.get(idx));
				nums.set(idx, temp);
				break;
			}
		}

		List<Integer> subList = nums.subList(idx+1, n);
		Collections.reverse(subList);

		return nums;
	}
}
