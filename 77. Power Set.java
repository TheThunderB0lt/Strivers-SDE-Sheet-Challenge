import java.util.* ;

import java.io.*; 

public class Solution {

    public static void powerSet( ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res,  ArrayList<Integer> inner, int i )

    {

        if( i == arr.size() )

        {

            res.add(new ArrayList<>(inner));

            return;

        }

 

        inner.add(arr.get(i));

        powerSet( arr, res, inner, (i+1) );

        inner.remove( inner.size()-1 );

 

        powerSet( arr, res, inner, (i+1));

    }

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) 

    {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> inner = new ArrayList<>();

        powerSet(arr, res, inner, 0);

        return res;

    }

}