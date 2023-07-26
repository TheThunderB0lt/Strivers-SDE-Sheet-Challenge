public class Solution {
	public static int cutRod(int prce[], int n) {
		int dp[][] = new int[n][n+1];
		for(int i =0;i<n;i++){
			for(int j =0;j<=n;j++){
				dp[i][j] = -1;
			}
		}
		return helper(prce, n-1, n,dp);
	}

	public static int helper(int a[],int i,int n,int dp[][]){
       if(i==0){
		   return n*a[0];
	   }
	   if(dp[i][n]!=-1){
		   return dp[i][n];
	   }
		int notTake = 0+ helper(a,i-1,n,dp);
		int   rodlength= i+1;
		int take = Integer.MIN_VALUE;
		if(rodlength<=n){
			 take = a[i]+helper(a, i, n-rodlength,dp);
		}
		return dp[i][n] = Math.max(take,notTake);
	}
}