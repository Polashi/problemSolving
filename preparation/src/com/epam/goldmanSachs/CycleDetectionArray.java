package com.epam.goldmanSachs;

public class CycleDetectionArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 0};
        int s1 = 0;
        System.out.println(getCircleLength(nums1, s1));
    }

    public static int getCircleLength(int[] arr, int index){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int slow = arr[index]; // arr[0] -> 1
        int fast = arr[arr[index]]; // arr[arr[0]] -> arr[1] -> 0
        int len = 1;
        if(fast == slow){
            return -1;
        }
        while(fast != slow){ // 1 and 0
            fast = arr[arr[fast]]; // arr[arr[0]] -> arr[1] -> 0
            slow = arr[slow]; // arr[1] -> 0
            len++; // 2
        }
        return len; // 2
    }
}
