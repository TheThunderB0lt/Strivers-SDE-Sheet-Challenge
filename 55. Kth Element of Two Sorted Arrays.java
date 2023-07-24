public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        if(m+n == k)
            return Math.max(row1[m-1],row2[n-1]);
        int i = 0;
        int j = 0;
        int t = 0;
        int ans = -1;
        while(i < row1.length && j < row2.length)
        {
            if(row1[i] <= row2[j])
            {
                ans = row1[i];
                t++;
                i++;
            }
            else{
                ans = row2[j];
                j++;
                t++;
            }

            if(t == k)
                return ans;
        }
        while(i<row1.length)
            {
                if(k == t)
                    return row1[i];
                t++;
                i++;
            }
        while(j<row2.length)
            {
                if(k == t)
                    return row2[j];
                t++;
                j++;
            }

            return -1;
    }
}
