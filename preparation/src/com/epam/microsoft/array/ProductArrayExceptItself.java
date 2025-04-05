package com.epam.microsoft.array;

public class ProductArrayExceptItself {
    public int[] getProduct(int[] nums){
        int n = nums.length;
        int [] product = new int[n+1];
        int temp = 1;
        for(int i=0; i<n; i++){
            product[i] = temp;
            temp = temp * nums[i];
        }

        temp =1;
        for (int i=n-1; i>=0; i--){
            product[i] *= temp;
            temp = temp * nums[i];
        }
        return product;
    }
}
