package com.epam.goldmanSachs;

public class MaximumSumContiguousSubArray {
    //Kadane's algo
    public static void main(String[] args) {
        System.out.println(sum(new int[]{5,-1,-8,6,8,1}));
    }
    public static int sum(int[] arr){
        int max_sum = 0;
        int curr_sum = 0;
        for(int a: arr){
            curr_sum += a;
            max_sum = Math.max(max_sum, curr_sum);
            if(curr_sum < 0){
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}
