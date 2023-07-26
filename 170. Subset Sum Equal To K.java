import java.util.* ;

import java.io.*; 

public class Solution {

    static int fun(int i ,int k,int[] arr,int[][] dp)

    {

        if(k==0) return 1;

 

        if(i==0) return (arr[i]==k)?1:0;

 

        if(dp[i][k]!=-1) return dp[i][k]; 

 

        int non=fun(i-1,k,arr,dp);

        int pick=0;

        if(k>=arr[i])

        pick=fun(i-1,k-arr[i],arr,dp);

 

        return dp[i][k]=non|pick;

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){

        // Write your code here.

        int[][] dp = new int[n][k+1];

        for(int[] a:dp)

            Arrays.fill(a,-1);

        return fun(n-1,k,arr,dp)==1?true:false;

 

    }

}