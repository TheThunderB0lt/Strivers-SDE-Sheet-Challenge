import java.util.ArrayList;

public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
		if(arr.isEmpty()){
			return 0;
		}
		
		int idx = 0;
		for(int i = 1; i < n; i++){
			if(!arr.get(i).equals(arr.get(idx))){
				idx++;
				arr.set(idx, arr.get(i));
			}
		}
		return idx + 1;
	}
}