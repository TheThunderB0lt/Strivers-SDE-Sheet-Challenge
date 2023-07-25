import java.util.*;

public class Solution {

    static class MinStack {
        Stack<Integer> stack; // Main stack to store the elements
        Stack<Integer> minStack; // Stack to store the minimum elements

        // Constructor
        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            stack.push(num); // Push the element to the main stack

            // Update the minimum stack with the current minimum element
            if (minStack.isEmpty() || num <= minStack.peek()) {
                minStack.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if (!stack.isEmpty()) {
                int popped = stack.pop(); // Pop the element from the main stack

                // Update the minimum stack if the popped element was the current minimum
                if (popped == minStack.peek()) {
                    minStack.pop();
                }

                return popped;
            } else {
                return -1;
            }
        }

        // Function to return the top element of stack if it is present. Otherwise return -1.
        int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else {
                return -1;
            }
        }

        // Function to return the minimum element of stack if it is present. Otherwise return -1.
        int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            } else {
                return -1;
            }
        }
    }
}
