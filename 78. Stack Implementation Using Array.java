public class Solution {
    static class Stack {
        int[] st;
        int top = -1;
        int cap;

        Stack(int capacity) {
            st = new int[capacity];
            this.cap = capacity;
        }

        public void push(int num) {
            if (isFull() != 1) {
                top = top + 1;
                st[top] = num;
            }
        }

        public int pop() {
            if (isEmpty() != 1) {
                int x = st[top];
                top = top - 1;
                return x;
            } else {
                // Return a unique value (e.g., -1_000_000) when the stack is empty
                return -1;
            }
        }

        public int top() {
            if (isEmpty() != 1) {
                return st[top];
            } else {
                return -1;
            }
        }

        public int isEmpty() {
            if (top == -1) {
                return 1;
            } else {
                return 0;
            }
        }

        public int isFull() {
            if (top == cap - 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
