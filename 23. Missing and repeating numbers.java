// GFG Code
// Better Solution -> TC : O(2N) & SC : O(N)

int[] findTwoElement(int arr[], int n) {
        // code here
         // code here
        int repeating = -1, missing = -1;

        // Count the occurrences
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Find the repeating and missing number
        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                repeating = i;
            } else if (count[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        int[] res = {repeating, missing};
        return res;
    }

// Optimal -> TC:O(N) && SC : (1)
int[] findTwoElement(int arr[], int n) {
        // code here
         int repeating = -1, missing = -1;

        // Find the repeating and missing numbers using the concept of indexing
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                repeating = Math.abs(arr[i]);
            } else {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        int[] res = {repeating, missing};
        return res;
    }


// =========================== CN ============================== //

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr.get(i));
            if (arr.get(num - 1) < 0) {
                repeating = num;
            } else {
                arr.set(num - 1, -arr.get(num - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0) {
                missing = i + 1;
                break;
            }
        }

        int[] res = new int[2];
        res[0] = missing;
        res[1] = repeating;
        return res;
    }
}

