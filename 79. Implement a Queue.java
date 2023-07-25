import java.util.*;

public class Queue {

    LinkedList<Integer> queue;

    Queue() {
        // Initialize the linked list to represent the queue
        queue = new LinkedList<>();
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Check if the queue is empty
        return queue.isEmpty();
    }

    void enqueue(int data) {
        // Add the data to the end of the queue (enqueue)
        queue.addLast(data);
    }

    int dequeue() {
        // Remove and return the front element from the queue (dequeue)
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }
        return queue.removeFirst();
    }

    int front() {
        // Return the front element of the queue
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }
        return queue.getFirst();
    }
}
