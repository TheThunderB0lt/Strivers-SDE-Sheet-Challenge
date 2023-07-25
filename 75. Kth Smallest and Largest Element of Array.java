import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

 

public class Solution {

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {

        //Write your code here

        ArrayList<Integer>list = new ArrayList<>();

        Collections.sort(arr);

        list.add(arr.get(k-1));

        list.add(arr.get(arr.size()-k));

        return list;

    }

}