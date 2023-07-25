import java.util.*;

public class Solution {
    public static boolean findPattern(String p, String s) {
        // Use indexOf to find the starting index of the first occurrence of pattern p in s
        int index = s.indexOf(p);

        // Check if the pattern exists in the string
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }
}
