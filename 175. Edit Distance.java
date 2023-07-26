
public class Solution {

    public static int editDistance(String str1, String str2) {
      int dp[][] = new int[str1.length()][str2.length()];
      for(int i =0;i<dp.length;i++){
          for(int j =0;j<dp[0].length;j++){
              dp[i][j] =-1;
          }
      }
       return helper(str1,str2,0,0,dp);
    }

    public static int helper(String a,String b,int i,int j,int dp[][]){
        if(i == a.length()&&j == b.length()){
            return 0;
        }
        if(i==a.length()){
            return b.length()-j;
        }
        if(j == b.length()){
            return a.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = 0+helper(a, b, i+1, j+1,dp);
        }else{
        int replace = 1+helper(a, b, i+1, j+1,dp);
        int delete = 1+helper(a, b, i, j+1,dp);
        int insert = 1+helper(a, b, i+1, j,dp);
        return dp[i][j]= Math.min(replace,Math.min(delete,insert));
    }
    }
}