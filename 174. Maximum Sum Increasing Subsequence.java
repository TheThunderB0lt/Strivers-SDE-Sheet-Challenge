import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
      int maxTillItself[] = new int[n];
      maxTillItself[0] = rack.get(0);
      for(int i =1;i<n;i++){
          int max = rack.get(i);
          for(int j =0;j<i;j++){
              if(rack.get(j)<rack.get(i)){
              max  =  Math.max(max, rack.get(i)+maxTillItself[j]);
              }
          }
          maxTillItself[i] = max;
      }
      int max = 0;
      for(int i =0;i<n;i++){
       max = Math.max(maxTillItself[i],max);
      }
      return max;
    }
}