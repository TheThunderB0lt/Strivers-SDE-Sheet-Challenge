import java.io.*;
import java.util.* ;

public class Solution {
    // TC : O(M * N), SC : O(1)
    public static void setZeros(int matrix[][]) {
        // Write your code here..
        int row = matrix.length;
        int col = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        //check if first row is 0 or not, col is fixed ie; set it to 0
        // if 1st row contains 0 break the loop
        for(int i = 0; i < col; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        // check if firstcol is 0 or not, row is fixed ie; set it to 0
        // if 1st row contains 0 break the loop
        for(int j = 0; j < row; j++){
            if(matrix[j][0] == 0){
                firstCol = true;
                break;
            }
        }

        // now mark 0 in the firstrow & firstcol
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; // 0th col is fixed, and row is changing
                    matrix[0][j] = 0; // 0th row is fixed, and col is changing
                }
            }
        }

        // set first row as zero except 0th row
        // run a loop from 1
        for(int i = 1; i < row; i++){
            if(matrix[i][0] == 0){ // check if 1st row of 0th col is 0 or not
                for(int j = 1; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // set first col as 0 except 0th col
        for(int j = 1; j < col; j++){
            if(matrix[0][j] == 0){ // row is fixed, col is changing
                for(int i = 1; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // set 0 in the 1st row if necessary
        if(firstRow){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}