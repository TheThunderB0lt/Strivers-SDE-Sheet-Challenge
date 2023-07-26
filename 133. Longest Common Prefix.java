public class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        if (n == 0) {
            return "";
        }
        
        int minLength = Integer.MAX_VALUE;
        for (String str : arr) {
            minLength = Math.min(minLength, str.length());
        }
        
        StringBuilder prefix = new StringBuilder();
        
        for (int i = 0; i < minLength; i++) {
            char currChar = arr[0].charAt(i); 
            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != currChar) {
                    return prefix.toString(); 
                }
            }
            
            prefix.append(currChar); 
        }
        
        return prefix.toString(); 
    }
}