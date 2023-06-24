import java.util.* ;
import java.io.*; 
public class Solution {
    public static long merge(long[] arr, int low, int mid, int high){
        ArrayList<Long> temp = new ArrayList<>();
        long cnt = 0;
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }

        return cnt;
    }
    public static long mergeSort(long arr[], int low, int high){
        long cnt = 0;
        if(low >= high) return cnt; // Base case
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        // Brute force sol: TC :O(N^2) & SC : O(1)
        // long cnt = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = i+1; j < n; j++){
        //         if(arr[i] > arr[j]){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

        // Optimal Sol : BY using mergesort algo 
        // TC : O(NLogN) && SC : O(N) -> bcoz of using temp arr

        return mergeSort(arr, 0, (int) n-1);
    }
}