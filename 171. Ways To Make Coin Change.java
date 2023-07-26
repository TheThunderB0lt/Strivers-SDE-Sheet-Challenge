import java.util.Arrays;

public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
    long dp[][] = new long[denominations.length][value+1];
	for(int i=0;i<denominations.length;i++){
		Arrays.fill(dp[i], -1);
	}
	return  helper(denominations,value,denominations.length-1,dp);		
	}
	public static long helper(int a[],int value,int i,long dp[][]){
      if(i == 0){
	  if(value%a[i] == 0){
            return 1;
	  }else{
		  return 0;
	  }
	  }
	  if(dp[i][value] != -1){
		  return dp[i][value];
	  }
    long notTake = helper(a, value, i-1,dp);
	long take = 0;
	if(a[i]<=value){
		take = helper(a, value-a[i], i,dp);
	}
     return dp[i][value] = take +notTake;
	}
}