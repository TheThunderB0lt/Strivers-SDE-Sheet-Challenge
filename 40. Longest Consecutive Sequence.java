import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        // if (arr.length == 0 || arr == null) return 0;
        // int res = 1;
        // int cnt = 1;
        // int prev = arr[0];

        // Arrays.sort(arr);
        // for (int i = 0; i < N; i++) {
        //     if (arr[i] == prev + 1) {
        //         cnt++;
        //     } else if (arr[i] != prev) {
        //         cnt = 1;
        //     }
        //     prev = arr[i];
        //     res = Math.max(res, cnt);
        // }
        // return res;

        // Optimal : O(N)
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr) {
            set.add(num);
        }

        int longest = 0;
        for(int num : arr) {
            if(!set.contains(num-1)) {
                int curr = num;
                int cnt = 1;
                while(set.contains(curr + 1)) {
                    curr++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}