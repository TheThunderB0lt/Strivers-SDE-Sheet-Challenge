
public class Solution {

	public static int lcs(String s, String t) {
		int dp[][] = new int[s.length()][t.length()];
        for(int i =0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j] = -1;
            }
        }
        return helper(s, t, 0, 0,dp);
    }
 
    public static int helper(String s,String t,int i,int j,int dp[][]){
        if(i==s.length()||j==t.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
             dp[i][j]= 1+ helper(s, t, i+1, j+1,dp);
             return dp[i][j];
        }else{
             dp[i][j] = Math.max(helper(s, t, i+1, j,dp),helper(s, t, i, j+1,dp));
             return dp[i][j];
        }
    }
}