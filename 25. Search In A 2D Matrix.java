import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        // Brute force : TC :(N*M) && SC :O(1)
        // int i = 0, j = mat.get(0).size()-1;

        // while(i < mat.size() && j >= 0){
        //     if(mat.get(i).get(j) == target){
        //         return true;
        //     }
        //     if(mat.get(i).get(j) > target){
        //         j--;
        //     } else {
        //         i++;
        //     }
        // }
        // return false;

        // Optimal: By using binary search
        // TC : O(Log(M*N)) && SC : O(1)

        if(mat.size() == 0) return false;

        int n = mat.size();
        int m = mat.get(0).size();

        int low = 0;
        int high = (n * m) -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(mat.get(mid/m).get(mid%m) == target) return true;
            if(mat.get(mid/m).get(mid%m) < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
