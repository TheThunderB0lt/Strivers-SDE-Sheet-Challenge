import java.util.ArrayList;

public class Solution {
public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
    int dp[][] = new int[weights.size()][w + 1];
    for (int i = 0; i < weights.size(); i++) {
        for (int j = 0; j <= w; j++) {
            dp[i][j] = -1;
        }
    }
    return helper(values, weights, w, 0, dp);
}

public static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int w, int i, int dp[][]) {
    if (i == weights.size() || w == 0) {
        return 0;
    }
    if (dp[i][w] != -1) {
        return dp[i][w];
    }
    if (weights.get(i) > w) {
        return dp[i][w] = helper(values, weights, w, i + 1, dp);
    }
    int a = values.get(i) + helper(values, weights, w - weights.get(i), i + 1, dp);
    int b = helper(values, weights, w, i + 1, dp);
    return dp[i][w] = Math.max(a, b);
}
}