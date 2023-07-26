import java.util.*;
import java.io.*;

public class Solution {
    public static int minSumPath(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
    
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + dp[i + 1][grid[0].length - 1];
        }
        
        for (int j = grid[0].length - 2; j >= 0; j--) {
            dp[grid.length - 1][j] = grid[grid.length - 1][j] + dp[grid.length - 1][j + 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        
        return dp[0][0];
    }
}