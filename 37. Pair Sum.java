import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]>li=new ArrayList<int[]>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;++i){
            int array[]=new int[2];
                for(int j=i;j<arr.length;++j){
                if(i!=j && arr[i]+arr[j]==s){
                    array[0]=arr[i];
                    array[1]=arr[j];
                    li.add(array);
                }
            }
        }
        return li;
    }
}
