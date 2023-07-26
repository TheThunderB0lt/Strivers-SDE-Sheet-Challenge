import java.util.HashSet;

public class Solution {
    public static int distinctSubstring(String word) {
        HashSet<String> substrings = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                substrings.add(word.substring(i, j));
            }
        }

        return substrings.size();
    }
}