import java.util.*;

public class Solution {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            // Move elements from auxStack to stack until the correct position is found for temp
            while (!auxStack.isEmpty() && auxStack.peek() < temp) {
                stack.push(auxStack.pop());
            }

            // Place temp in the correct position in auxStack
            auxStack.push(temp);
        }

        // Copy elements from auxStack back to stack to get the sorted order
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }
}
