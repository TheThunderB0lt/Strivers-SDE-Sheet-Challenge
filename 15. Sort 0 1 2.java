import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr){
        // // Better:: TC : O(2N), SC : O(1)
        // int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // for(int i = 0; i < arr.length; i++){
        //     if(arr[i] == 0) cnt0++;
        //     else if(arr[i] == 1) cnt1++;
        //     else cnt2++;
        // }

        // for(int i = 0; i < cnt0; i++) arr[i] = 0;
        // for(int i = cnt0; i < cnt0 + cnt1; i++) arr[i] = 1;
        // for(int i = cnt0 + cnt1; i < arr.length; i++) arr[i] = 2;

        // Optimal approach : Dutch National Flag algo - TC : O(N) && SC : O(1);
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}