import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int totalpaths = m+n-2;

        int r=m-1;

        double res =1;

        for (int i=1;i<=r;i++){

            res=res*(totalpaths-r+i)/i;

 

        }

        return (int)res;
	}
}