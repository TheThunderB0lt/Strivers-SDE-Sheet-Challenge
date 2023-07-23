import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] height, int n) {
        // Write your code here.
        // int n=height.length;

        long resultantWaterStore=0;
        int left=0;
        int right=n-1;
        long leftMax=0;
        long rightMax=0;

        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    resultantWaterStore+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    resultantWaterStore+=rightMax-height[right];
                }
                right--;
            }
        }
        return resultantWaterStore;
    }
}