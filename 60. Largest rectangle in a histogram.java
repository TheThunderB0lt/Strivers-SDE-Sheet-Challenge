import java.util.ArrayList;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.
    int n = heights.size();

    int[]left = new int[n];

    int[] right = new int[n];

    int area = 0;

    left[0] = 0;

    right[n-1]=n-1;

    for(int i=1;i<n;i++){

     int prev = heights.get(i-1);

     int curr = heights.get(i);

     if(prev > curr){

       int k = i;

       while(k>=0 && heights.get(k)>=curr){

         left[i] = k;

         k--;

       }

 

     }

     else if(prev==curr){

       left[i] = left[i-1];

     }else{

       left[i] = i;

     }

    }

 

    for(int i=n-2;i>=0;i--){

      int next = heights.get(i+1);

      int curr = heights.get(i);

      if(next>curr){

        int k = i;

        while(k<n && heights.get(k)>=curr){

          right[i] = k;

          k++;

        }

        

      }

      else if(next==curr){

        right[i] = right[i+1];

      }else{

        right[i] = i;

      }

    }

 

    for(int i=0;i<n;i++){

      int h = heights.get(i);

      int l = left[i];

      int r = right[i];

      int w = r-l+1;

      area = Math.max(area, h*w);

    }

    return area;
  }
}