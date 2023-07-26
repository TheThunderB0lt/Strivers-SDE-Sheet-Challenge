import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            if (pq.size() < K) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}