import java.util.ArrayList;

import java.util.HashSet;

import java.util.*;

 

public class Solution {

    public static String kthPermutation(int n, int k) {

        // Write your code here.

        String s = "";

        HashSet<Integer> hs = new HashSet<>();

        int pos = 1;

        int[] arr = new int[9];

        int[] fact = new int[10];

        fact[0] =1;

        int size = n;

        for(int i=0;i<9;i++){

            arr[i] = i+1;

            fact[i+1] = fact[i]*(i+1);

        }

        while(pos<=n){

            int com = fact[n-pos];

            int ele = k%com == 0?k/com:(k/com)+1;

            ele = (ele)%size;

            ele = ele == 0?size-1:ele-1;

            int i = arr[ele];

            s+=(i)+"";

            arr[ele] = Integer.MAX_VALUE;

            pos++;

            Arrays.sort(arr);

            size--;

        }

        return s;

    }

}