import java.util.ArrayList;


public class Solution {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            minElement = Math.min(minElement, matrix.get(i).get(0));
            maxElement = Math.max(maxElement, matrix.get(i).get(n - 1));
        }

        int desiredIndex = (m * n + 1) / 2; 
        while (minElement < maxElement) {
            int mid =   (maxElement + minElement) / 2;
            int count = 0;

            for (int i = 0; i < m; i++) {
                int rowCount = countElementsLessThanOrEqualTo(matrix.get(i), mid);
                count += rowCount;
            }

            if (count < desiredIndex) {
                minElement = mid + 1;
            } else {
                maxElement = mid;
            }
        }

        return minElement;
    }

    private static int countElementsLessThanOrEqualTo(ArrayList<Integer> row, int target) {
        int left = 0;
        int right = row.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = row.get(mid);

            if (num <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}