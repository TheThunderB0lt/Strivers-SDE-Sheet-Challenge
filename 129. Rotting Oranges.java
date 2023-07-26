import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int minTimeToRot(int[][] grid, int n, int m) {
        int fresh = 0;
        int rotten = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten++;
                    queue.offer(new Pair(i, j));
                }
            }
        }
		if(fresh ==0){return 0;}
        int time = -1;

        while ( !queue.isEmpty()) {
            time++;

            int size = queue.size();

            while (size > 0) {
                Pair p = queue.poll();
                int i = p.i;
                int j = p.j;

                // Check the adjacent cells (up, down, left, right) and update the grid and queue accordingly
                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    // Check if the new coordinates are within the grid boundaries
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Update the fresh orange to rotten
                        fresh--; // Decrease the count of fresh oranges
                        queue.offer(new Pair(newRow, newCol)); // Push the new rotten orange to the queue
                    }
                }

                size--;
            }
            rotten = queue.size();
        }

        // Finally, return the minimum time required to rot all the fresh oranges
        return fresh == 0 ? time : -1;
    }
}