public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        for(int i=0;Math.pow(i,n)<=m;i++){
            if(Math.pow(i,n) == m){
            return i;
            }

        }
        return -1;
    }
}
