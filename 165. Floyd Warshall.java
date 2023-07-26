import java.util.ArrayList;

public class Solution {
  static int INF = 1000000000; // A high value to represent infinity

  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    int[][] dist = new int[n + 1][n + 1];

    // Initialize the distance matrix with infinity for all pairs
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dist[i][j] = INF;
      }
    }

    for (ArrayList<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      int weight = edge.get(2);
      dist[u][v] = weight;
    }

    for (int i = 1; i <= n; i++) {
      dist[i][i] = 0;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    return dist[src][dest];
  }
}