import java.util.* ;
import java.io.*; 
public class Solution {

	public static int palindromePartitioning(String str) {
	  int dp[] = new int[str.length()];
      Arrays.fill(dp, -1);
      return helper(str, 0,dp)-1;
	}

    public static int helper(String s,int i,int dp[]){
        if(i == s.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s.substring(i,j+1))){
                int cost = 1+helper(s,j+1,dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    public static boolean isPalindrome(String s){
        if(s.length() <=1){
            return true;
        }
        int i =0;int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
    }
    return true;
}
}