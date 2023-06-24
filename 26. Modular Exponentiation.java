import java.io.*;
import java.util.* ;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.    
        if (n == 0) {
            return 1;
        }

        long res = 1;
        long base = x % m;

        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * base) % m;
            }
            base = (base * base) % m;
            n /= 2;
        }

        return (int) res;
    }
}