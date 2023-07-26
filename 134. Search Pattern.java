import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> stringMatch(String text, String pattern) {
        List<Integer> ans = new ArrayList<>();
        // if (text.length() > pattern.length()) {
        //     return ans;
        // }
        
        int hashOfText = hash(text);
        int currentHash = 0;
        boolean isMatching = true;
        
        for (int i = 0; i < text.length(); i++) {
            currentHash += pattern.charAt(i) - 'a' + 1;
            if (text.charAt(i) != pattern.charAt(i)) {
                isMatching = false;
            }
        }
        
        if (isMatching) {
            ans.add(1);
        }
        
        int j = 0;
        
        for (int i = text.length(); i < pattern.length(); i++) {
            currentHash -= pattern.charAt(j) - 'a' + 1;
            currentHash += pattern.charAt(i) - 'a' + 1;
            j++;
            
            if (currentHash == hashOfText) {
                isMatching = true;
                int l = 0;
                
                
                for (int k = j; k <= i && l < text.length(); k++) {
                    if (text.charAt(l) != pattern.charAt(k)) {
                        isMatching = false;
                        break;
                    }
                    l++;
                }
                
                if (isMatching) {
                    int m = j+1;
                    ans.add((m));
                }
            }
        }
        
        return ans;
    }

    public static int hash(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) - 'a' + 1;
        }
        return ans;
    }
}