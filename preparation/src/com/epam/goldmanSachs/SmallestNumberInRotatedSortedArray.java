package com.epam.goldmanSachs;

public class SmallestNumberInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(getSmallestNumber(nums));
    }
    public static int getSmallestNumber(int[] arr){
        int n = arr.length;
        int start =0;
        int end = n-1;
        while(start <end){
            int mid = (start+end)/2;
            if(arr[mid] > arr[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return arr[start];

    }
}
