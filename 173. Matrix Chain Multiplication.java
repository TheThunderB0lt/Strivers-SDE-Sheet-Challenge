import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
	  int dp[][] = new int[N][N];
      for(int i =0;i<N;i++){
        for(int j = 0;j<N;j++){
            dp[i][j] =-1;
         }
      }
       return helper(arr, 1, N-1,dp);
	}

    public static int helper(int a[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
       int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int cost = a[i-1]*a[k]*a[j]+
               helper(a,i,k,dp)+helper(a, k+1, j,dp);
            min = Math.min(cost,min);
        }
         dp[i][j] =  min;
         return min;
    }
}