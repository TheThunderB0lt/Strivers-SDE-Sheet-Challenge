public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;

        // tail[i] represents the minimum ending element of the LIS with length i+1
        int[] tail = new int[n];
        int len = 0; // Length of the longest increasing subsequence found so far

        for (int num : arr) {
            // Binary search to find the position to update or append in the tail array
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Update or append the number to the tail array
            tail[left] = num;

            // If we appended the number, increase the length of the LIS
            if (left == len) {
                len++;
            }
        }

        return len;
    }
}