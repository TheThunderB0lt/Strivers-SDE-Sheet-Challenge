import java.util.*;

public class Solution {
    public static int romanToInt(String s) {
        // Create a mapping of Roman numerals to their integer values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0; // To handle subtraction cases

        // Iterate through the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanValues.get(currentChar);

            // If the current value is less than the previous value, we have a subtraction case
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            // Update the previous value for the next iteration
            prevValue = currentValue;
        }

        return result;
    }
}
