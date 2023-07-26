import java.util.*;

public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        HashSet<String> set = new HashSet<>();
        for (String e : arr) {
            set.add(e);
        }

        // Initialize the memoization table to store results of subproblems.
        HashMap<String, Boolean> memo = new HashMap<>();
        return helper(target, set, memo);
    }

    public static boolean helper(String s, HashSet<String> set, HashMap<String, Boolean> memo) {
        if (s.length() <= 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 0; i < s.length(); i++) {
            String contains = s.substring(0, i + 1);
            if (set.contains(contains)) {
                String rem = s.substring(i + 1);
                if (rem.length() <= 0 || helper(rem, set, memo)) {
                    // If the remaining part is empty or can be broken using the set, return true.
                    memo.put(s, true);
                    return true;
                }
            }
        }

        // If no combination of substrings from the set can form the target string.
        memo.put(s, false);
        return false;
    }
}