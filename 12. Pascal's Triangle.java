import java.io.*;
import java.util.* ;

// Importing ArrayList class from Java's Util Library
import java.util.ArrayList;

public class Solution {

	// Method to print Pascal Triangle
	public static ArrayList<ArrayList<Long>> printPascal(int n) {

		// Creating an ArrayList of ArrayLists called 'res'
		ArrayList<ArrayList<Long>> res = new ArrayList<>();

		// Looping through each row of the triangle, ranging from 0 to n-1
		for(int i = 0; i < n; i++){

			// Creating a new ArrayList called row to store values of current row
			ArrayList<Long> row = new ArrayList<>();

			// Looping through each element of the row, ranging from 0 to i
			for(int j = 0; j <= i; j++){

				// Checking if element is either first or last, and should be set to 1
				if(j == 0 || j == i){
					row.add(1L);
				} 

				// If element is not first or last, calculate its value based on previous row
				else {
					long val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
					row.add(val);
				}
			}

			// Adding current row to the final result array
			res.add(row);
		}

		// Returning the result array
		return res;
	}
}


// The printPascal() function loops over each row of the triangle, and within each row, 
// it loops over each element of the row, populating an ArrayList called row with the values. 
// If the element is either the first or last element of the current row, it sets its value to 1. 
// Otherwise, it calculates the value based on the previous row's element and adds it to the current row.