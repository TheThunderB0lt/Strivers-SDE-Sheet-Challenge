import java.util.* ;

import java.io.*; 

public class Solution {

//TC=2powN+2powNlog(2powN)

 

 static void findSumSet(int index,int sum,int arr[],int N,ArrayList<Integer> list){

     if(index==N)

     {

        list.add(sum);

        return;

     }

        findSumSet(index+1,sum+arr[index],arr,N,list);

        findSumSet(index+1,sum,arr,N,list);

 

    }

 

    public static ArrayList<Integer> subsetSum(int num[]) {

 

        // Write your code here..

        ArrayList<Integer> list=new ArrayList<>();

       

            findSumSet(0,0,num,num.length,list);

        

        Collections.sort(list);

        return list;

 

    }

 

}