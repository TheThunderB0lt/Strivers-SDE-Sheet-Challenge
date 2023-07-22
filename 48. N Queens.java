import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] arr = new int[n][n];
        solve(0, arr, ans);
        return ans;
    }

    static void solve(int col, int[][] arr, ArrayList<ArrayList<Integer>> ans){
        if(col == arr.length){
            addBoard(arr, ans);
            return;
        }

        for(int row=0; row<arr.length; row++){
            if(isSafe(row, col, arr)){
                arr[row][col] = 1;
                solve(col+1, arr, ans);
                arr[row][col] = 0;
            }
        }
    }

    static boolean isSafe(int row, int col, int[][] arr){
        int ux = row, uy = col;
        while(ux >= 0 && uy >= 0){
            if(arr[ux][uy] == 1)    return false;
            ux--;
            uy--;
        }

        int ly = col;
        while(ly >= 0){
            if(arr[row][ly] == 1)   return false;
            ly--;
        }

        int dx = row, dy = col;
        while(dx < arr.length && dy >= 0){
            if(arr[dx][dy] == 1)    return false;
            dx++;
            dy--;
        }

        return true;
    }

    static void addBoard(int[][] arr, ArrayList<ArrayList<Integer>> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++)
                temp.add(arr[i][j]);
        }
        ans.add(temp);
    }
}