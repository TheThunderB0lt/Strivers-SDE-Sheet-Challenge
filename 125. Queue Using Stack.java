import java.util.Stack;
public class Solution{
    static class Queue {
        // Define the data members(if any) here.
        private Stack<Integer> st1;    
        private Stack<Integer> st2;

        Queue() {
            // Initialize your data structure here.
            st1 = new Stack<Integer>();        
            st2 = new Stack<Integer>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            st1.push(val);
        }

        int deQueue() {
            // Implement the dequeue() function.
            if(isEmpty()){
            return -1;
        }

        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        int removed = st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return removed;
        }

        int peek() {
            // Implement the peek() function here.
            if(isEmpty()){

            return -1;

        }

        while(!st1.isEmpty()){

            st2.push(st1.pop());

        }

        int peeked = st2.peek();

        while(!st2.isEmpty()){

            st1.push(st2.pop());

        }

        return peeked;
        }

        boolean isEmpty() {
            // Implement the isEmpty() function here.
            if(st1.isEmpty()){

            return true;

        }

        return false;
        }
    }
}