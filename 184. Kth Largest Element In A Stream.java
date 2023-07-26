import java.util.PriorityQueue;

public class Kthlargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public Kthlargest(int k, int[] arr) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int num : arr) {
            add(num);
        }
    }

    public void add(int num) {
        if (pq.size() < k) {
            pq.offer(num);
        } else if (num > pq.peek()) {
            pq.poll();
            pq.offer(num);
        }
    }

    public int getKthLargest() {
        return pq.peek();
    }
}