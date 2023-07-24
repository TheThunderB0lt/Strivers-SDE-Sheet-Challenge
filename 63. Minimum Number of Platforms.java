import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int arr[], int dep[], int n) {
        // Write your code here.
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1; // Initialize the number of platforms needed to 1
        int maxPlatforms = 1; // Initialize the maximum number of platforms needed

        int i = 1; // Pointer for the departure array
        int j = 0; // Pointer for the arrival array

        // Iterate over the arrival and departure arrays
        while (i < arr.length && j < dep.length) {
            // If a train is arriving before the previous train has departed,
            // increment the number of platforms needed and move the arrival pointer
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            }
            // If a train is departing before the next train arrives,
            // decrement the number of platforms needed and move the departure pointer
            else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }

            // Update the maximum number of platforms needed
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }
}