import java.util.* ;
import java.io.*; 
public class Solution {
	public static String graphColoring(int[][] mat, int m) {
		int color[] = new int[mat.length];
		boolean poss = colorGraph(mat,m,color,0);
		if(poss){
           return "YES";
		}else{
			return "NO";
		}
	}

	  private static boolean colorGraph(int[][] mat, int m, int[] colors, int node) {
        int n = mat.length; // Number of nodes in the graph

        // Base case: If all nodes are colored
        if (node == n) {
            return true;
        }

        // Try all colors for the current node
        for (int color = 1; color <= m; color++) {
            if (isSafe(mat, colors, node, color)) {
                colors[node] = color; // Assign the color

                // Recursively color the remaining nodes
                if (colorGraph(mat, m, colors, node + 1)) {
                    return true;
                }

                // If coloring fails, backtrack and try a different color
                colors[node] = 0;
            }
        }

        return false; // No valid color found
    }

    private static boolean isSafe(int[][] mat, int[] colors, int node, int color) {
        int n = mat.length; // Number of nodes in the graph

        // Check if the current color conflicts with adjacent nodes
        for (int i = 0; i < n; i++) {
            if (mat[node][i] == 1 && colors[i] == color) {
                return false;
            }
        }

        return true;
    }
}