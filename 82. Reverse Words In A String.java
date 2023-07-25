public class Solution {
    public static String reverseString(String str) {
        // Split the input string into words using whitespace as the delimiter
        String[] words = str.split("\\s+");

        StringBuilder reversedString = new StringBuilder();

        // Append the words to the StringBuilder in reverse order with a single space between them
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(" ");
            }
        }

        // Return the final reversed string after trimming leading and trailing spaces
        return reversedString.toString().trim();
    }
}
