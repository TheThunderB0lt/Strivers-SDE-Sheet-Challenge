import java.io.*;
import java.util.* ;

import java.util.ArrayList;

// Brute force solution - TC : O(N^2) & SC : O(1)
public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){

        for(int i = 0; i < n; i++){ // O(N)
            for(int j = i+1; j < n; j++){ //O(n)
                if(arr.get(i).equals(arr.get(j))){ // same as (arr[i] == arr[j])
                    return arr.get(i); // Finally, the duplicate number is returned as the output.
                }
            }
        }
        return -1; // if no duplicates then return -1
    }
}

// Optimal Solution by Using HashSet
// TC : O(N) && SC : (N) if its duplicates in worst case, O(1) - if no duplicates

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        
        return -1;
    }
}