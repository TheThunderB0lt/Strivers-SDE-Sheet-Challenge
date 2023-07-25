import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> distinctCounts = new ArrayList<>();

        // Edge case: If k is greater than the array size, return empty list
        if (k > arr.size()) {
            return distinctCounts;
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count distinct elements in the first window of size k
        for (int i = 0; i < k; i++) {
            frequencyMap.put(arr.get(i), frequencyMap.getOrDefault(arr.get(i), 0) + 1);
        }
        distinctCounts.add(frequencyMap.size());

        // Slide the window and update distinct element count for each subsequent window
        for (int i = k; i < arr.size(); i++) {
            // Remove the element going out of the window
            int removedElement = arr.get(i - k);
            if (frequencyMap.get(removedElement) == 1) {
                frequencyMap.remove(removedElement);
            } else {
                frequencyMap.put(removedElement, frequencyMap.get(removedElement) - 1);
            }

            // Add the element coming into the window
            int newElement = arr.get(i);
            frequencyMap.put(newElement, frequencyMap.getOrDefault(newElement, 0) + 1);

            distinctCounts.add(frequencyMap.size());
        }

        return distinctCounts;
    }
}