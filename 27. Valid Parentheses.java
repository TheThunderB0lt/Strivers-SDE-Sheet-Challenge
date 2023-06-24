import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(!st.isEmpty() && st.peek() == '(' && ch == ')'){
                st.pop();
            }
            else if(!st.isEmpty() && st.peek() == '[' && ch == ']') {
                st.pop();
            }
            else if(!st.isEmpty() && st.peek() == '{' && ch == '}') {
                st.pop();
            }
            else {
                st.push(ch);
            }
        }

        if(st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}