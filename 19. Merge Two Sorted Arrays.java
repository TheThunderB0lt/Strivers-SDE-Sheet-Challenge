import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int left = 0;
        int right = 0;
        int idx = 0;
        int[] arr3 = new int[m+n];

        while(left < m && right < n){
            if(arr1[left] <= arr2[right]){
                arr3[idx] = arr1[left];
                left++;
                idx++;
            } else {
                arr3[idx] = arr2[right];
                right++;
                idx++;
            }
        }

        while(left < m){
            arr3[idx++] = arr1[left++];
        }

        while(right < n){
            arr3[idx++] = arr2[right++];
        }

        // for(int i = 0; i < m+n; i++){
        //     if(i < n) arr1[i] = arr3[i];
        //     else arr2[i-n] = arr3[i];
        // }
        
        return arr3;
    }
}
