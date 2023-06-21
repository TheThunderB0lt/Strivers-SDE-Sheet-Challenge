import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// Brute Force : TC : O(N^2), SC : O(1)
		long maxi = Long.MIN_VALUE;

		for(int i = 0; i < n; i++){
			long sum = 0;
			for(int j = i; j < n; j++){
				sum += arr[j];
				maxi = Math.max(maxi, sum);
			}
		}
		if (maxi < 0) maxi = 0;

		return maxi;
		
        // ------------------------------------------------------------ //

		// Optimal : TC : O(N), SC : O(1)
		long maxi = Long.MIN_VALUE;
		long sum = 0;

		for(int i = 0; i < n; i++){
			sum += arr[i];

			if(sum > maxi){
				maxi = sum;
			}
			if(sum < 0){
				sum = 0;
			}
		}
		if(maxi < 0) maxi = 0;

		return maxi;
	}
}
