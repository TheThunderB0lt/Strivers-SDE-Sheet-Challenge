import java.util.* ;
import java.io.*; 
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        return allocate(time, n);
    }
    
    public static boolean allocation(int a[], long n, int s) {
    long count = 0;
    int k = 1;
    for (int i = 0; i < a.length; i++) {
        if (a[i] > n) {
            return false; // Book time exceeds maximum time, allocation not possible
        }
        count += a[i];
        if (count <= n) {
            // Continue allocating books to the current student
        } else {
            count = a[i];
            k++;
        }
    }
    if (k > s) {
        return false; // More students required than available
    }
    return true;
}

public static long allocate(int a[], int k) {
    long low = 0;
    long high = 0;
    for (int e : a) {
        high += e;
    }
    long ans = high;
    while (low <= high) {
        long mid = (low + high) / 2;
        if (allocation(a, mid, k)) {
            ans = Math.min(ans, mid);
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

}