package com.epam.goldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(intervals, (a1,a2)->Integer.compare(a1[0], a2[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i< intervals.length; i++){
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];
            if(end >= curr_start){
                curr_start = Math.min(curr_start,start);
                curr_end = Math.max(end, curr_end);
            }else{
                List<Integer> temp = Arrays.asList(start, end);
                result.add(temp);
                start = curr_start;
                end = curr_end;
            }
        }
        List<Integer> pair = Arrays.asList(start,end);
        result.add(pair);
        int[][] ans = result.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        return ans;
    }
}
