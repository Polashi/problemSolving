package com.epam.goldmanSachs;

public class RotateArrayFromIndex {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7}; // 2,1,7,6,5,4,3 -> 3,4,5,6,7,1,2
        int[] output = rotate(input,2); //3,4,5,6,7,1,2
        for (int i = 0; i < output.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static int[] rotate(int[] input, int index) {
        int n = input.length;
        //reverse first half
        reverse(input, 0, index-1);
        reverse(input, index, n-1);
        reverse(input, 0, n-1);
        return input;
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
}
