import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
       Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
         for(int i =0;i<price.size();i++){
               ans.add(-1);
            }
       for(int i =price.size()-1;i>=0;i--){
           if(s.isEmpty()||!s.isEmpty()&&price.get(i)<=price.get(s.peek())){
               s.push(i);
           }else{
               while(!s.isEmpty()&&price.get(s.peek())<price.get(i)){
                   ans.set(s.peek(),i);
                   s.pop();
               }
               s.push(i);
           }
       }
    
      for(int i =0;i<ans.size();i++){
          if(ans.get(i) == -1){
              ans.set(i,i+1);
          }else{
              ans.set(i, i-ans.get(i));
          } 
      }
      return ans;
    }
}