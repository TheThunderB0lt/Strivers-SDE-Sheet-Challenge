import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> mergedIntervals = new ArrayList<>();

        // Sort the intervals based on their start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        // Add the first interval to the list of merged intervals
        Interval currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        // Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // Check if there is an overlap with the current interval
            if (intervals[i].start <= currentInterval.finish) {
                // There is an overlap, update the end time of the current interval
                currentInterval.finish = Math.max(intervals[i].finish, currentInterval.finish);
            } else {
                // No overlap, add the current interval to the list of merged intervals
                currentInterval = intervals[i];
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals;
    }
}
