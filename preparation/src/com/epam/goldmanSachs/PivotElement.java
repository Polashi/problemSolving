package com.epam.goldmanSachs;

public class PivotElement {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        //ans= -1;
        int[] array1 ={5,4,3,2,1};
        //ans = -1;
        int[] array2 = {5,4,1,2,3};
        //int ans=1;
        int[] array3 = {1,2,5,4,3};
        //int ans=5;
        System.out.println(findPivot(array));
    }

    public static int findPivot(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean leftAscending = true;
            boolean leftDescending = true;
            boolean rightAscending = true;
            boolean rightDescending = true;

            // Check the left part
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[j + 1]) {
                    leftAscending = false;
                }
                if (arr[j] <= arr[j + 1]) {
                    leftDescending = false;
                }
            }

            // Check the right part
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] <= arr[j + 1]) {
                    rightDescending = false;
                }
                if (arr[j] >= arr[j + 1]) {
                    rightAscending = false;
                }
            }

            if ((leftAscending || leftDescending) && (rightAscending || rightDescending)) {
                return arr[i];
            }
        }

        return -1;
    }
}
