import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> nums) 
    {
        // Write your code here.
        // Brute Force : O(N^2) && SC :O(2)
        // ArrayList<Integer> res = new ArrayList<>();

        // for(int i = 0; i < nums.size(); i++){
        //     if(res.size() == 0 || res.get(0) != nums.get(i)){
        //         int cnt = 0;
        //         for(int j = 0; j < nums.size(); j++){
        //             if(nums.get(j) == nums.get(i)){
        //                 cnt++;
        //             }
        //         }
        //         if(cnt > nums.size() / 3){
        //             res.add(nums.get(i));
        //         }
        //     }
        //     if(res.size() == 2) break;
        // }
        // return res;

        // Better : TC : O() && SC : O(N)

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        int mini = (int)(nums.size() / 3) + 1;

        for(int i = 0; i < nums.size(); i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);

            if(map.get(nums.get(i)) == mini){
                res.add(nums.get(i));
            }

            if(res.size() == 2) break;
        }
        return res;
    }
}