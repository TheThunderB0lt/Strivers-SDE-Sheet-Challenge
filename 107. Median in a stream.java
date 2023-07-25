import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int[] medians = new int[n];
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>(); // Min heap
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            // Insert element into the heaps based on their values
            if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
            }
            
            // Balance the heaps to ensure left heap size is either equal to or one greater than the right heap
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.offer(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }
            
            // Calculate the median based on the sizes of the heaps
            if (i % 2 == 0) {
                medians[i] = leftHeap.peek();
            } else {
                medians[i] = (leftHeap.peek() + rightHeap.peek()) / 2;
            }
        }
        
        return medians;
    }
}
