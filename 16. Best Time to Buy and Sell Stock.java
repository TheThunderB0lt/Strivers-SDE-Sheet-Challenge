import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.size(); i++){
            if(prices.get(i) < minPrice){
                minPrice = prices.get(i);
            } else if(prices.get(i) - minPrice > maxProfit){
                maxProfit = prices.get(i) - minPrice;
            }
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // Initialize the minimum price to a large value and the maximum profit to 0
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Iterate through the prices array
        for (int i = 0; i < n; i++) {
            // Update the minimum price if a lower price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Calculate the profit if selling on the current day and 
            // update the maximum profit if it's greater
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        // Return the maximum profit
        return maxProfit;
    }
}