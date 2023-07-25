public class Solution {

	public static boolean isItSudoku(int matrix[][]) {
          if(solve(matrix)){
			  return true;
		  }else{
			  return false;
		  }
	}

	public static boolean isValid(int a[][],int row,int col,int number) {
		for(int i =0;i<9;i++) {
			if(a[i][col]==number) {
				return false;
			}
			if(a[row][i] == number) {
				return false;
			}
			if(a[3*(row/3)+i/3][3*(col/3)+i%3]==number) {
				return false;
			}
		}
		return true;
	}
	public static boolean solve(int a[][]) {
    	   for(int i =0;i<a.length;i++) {
    		   for(int j =0;j<a.length;j++) {
    			   if(a[i][j] == 0) {
    				   for(int numbertotry =1;numbertotry<=9;numbertotry++) {
    					   if(isValid(a,i,j,numbertotry)) {
    						   a[i][j] = numbertotry;
    						   if(solve(a)) {
    							   return true;
    						   }else {
    							   a[i][j] = 0;
    						   }
    					   }
    					   
    				   }
    				   return false;
    			   }
    		   }
    	   }
    	   return true;
       }
}