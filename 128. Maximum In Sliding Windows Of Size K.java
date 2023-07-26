import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums.get(i) >= nums.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i < nums.size(); i++) {
            // The front of the deque contains the maximum element for the previous window
            result.add(nums.get(deque.peekFirst()));

            // Remove elements outside the current window from the deque
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums.get(i) >= nums.get(deque.peekLast())) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Add the maximum element of the last window
        result.add(nums.get(deque.peekFirst()));

        return result;
    }
}