package com.epam.goldmanSachs;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10};
        int[] arr2 = {2, 3, 5, 6};
        int[] ans = merge(arr1, arr2);
        for(int a: ans){
            System.out.print(a+ " ");
        }
    }

    public static int[] merge(int[] a1, int[] a2){
        int n = a1.length;
        int m = a2.length;
        int left = n-1;
        int right = 0;
        while(left>=0 && right<m){
            if(a1[left] > a2[right]){
                int temp = a1[left];
                a1[left] = a2[right];
                a2[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int[] ans = new int[n+m];
        int i=0;
        int j = 0;
        while(j<n){
            ans[i] = a1[j];
            i++;
            j++;
        }
        j= 0;
        while(j<m){
            ans[i]=a2[j];
            i++;
            j++;
        }
        return ans;
    }
}
