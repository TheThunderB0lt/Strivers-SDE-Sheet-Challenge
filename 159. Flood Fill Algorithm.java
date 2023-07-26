public class Solution {
    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        int prevColor = image[x][y];
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, x, y, newColor, prevColor,visited);
        return image;
    }

    public static void helper(int[][] image, int row, int col,
     int newColor, int prevColor,boolean visited[][]) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length ||
         image[row][col] != prevColor||visited[row][col] == true) {
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;
        helper(image, row + 1, col, newColor, prevColor,visited);
        helper(image, row, col + 1, newColor, prevColor,visited);
        helper(image, row - 1, col, newColor, prevColor,visited);
        helper(image, row, col - 1, newColor, prevColor,visited);
        visited[row][col] = false;
    }
}