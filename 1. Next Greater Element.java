import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
		Stack<Integer> st = new Stack<>();

		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			while(!st.isEmpty() && arr[st.peek()] < arr[i]){
				int idx = st.pop();
				res[idx] = arr[i];
			}
			st.push(i);
		}

		while(!st.isEmpty()){
			int idx = st.pop();
			res[idx] = -1;
		}

		return res;
	}

}
