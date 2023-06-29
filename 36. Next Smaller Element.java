import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr.get(st.peek()) > arr.get(i)){
                int idx = st.pop();
                res.set(idx, arr.get(i));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int idx = st.pop();
            res.set(idx, -1);
        }
        return res;
    }
}