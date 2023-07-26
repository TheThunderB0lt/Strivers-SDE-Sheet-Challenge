import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
	   int maxProduct = Integer.MIN_VALUE;
      int prefix = 1;
	  int suffix = 1;
    for(int i =0;i<n;i++){
		prefix = prefix*arr.get(i);
		maxProduct = Math.max(maxProduct, prefix);
		if(prefix==0){
			prefix=1;
		}
	}
	for(int i =n-1;i>=0;i--){
		suffix = suffix*arr.get(i);
		maxProduct = Math.max(suffix, maxProduct);
		if(suffix == 0){
			suffix = 1;
		}
	}
	return maxProduct;
	}
}