package com.epam.google.top30.array;

public class FindDuplicateInArray {
    public static int findDuplicateNumber(int[] nums){
        int n = nums.length;
        int duplicate = 0;
        for(int bit = 0; bit<32; bit++){
            int actualCount = 0;
            int expectedCount = 0;
            int mask = 1<<bit;

            for(int num: nums){
                if((num & mask) !=0){
                    actualCount++;
                }
            }
            for(int i=1; i<=n; i++){
                if((i & mask) != 0){
                    expectedCount++;
                }
            }
            if(actualCount > expectedCount){
                duplicate |= mask;
            }
        }
        return duplicate;
    }
}
