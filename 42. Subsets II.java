import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
        helper(0, new ArrayList<>(), ds, arr);
        return ds;
    }

    public static void helper(int idx, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> ds, int[] nums) {
        ds.add(new ArrayList<>(res));
        for(int i = idx; i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i-1]) continue;
            res.add(nums[i]);
            helper(i+1, res, ds, nums);
            res.remove(res.size()-1);
        }
    }

}