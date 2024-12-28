package com.epam.google;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {

    }

    int[] arr;
    int[] prefix = new int[arr.length];

    public RangeSumQueryImmutable(int[] nums) {
        arr = nums;
    }

    private int getPrefixSum(int index) {
        prefix[0] = arr[0];
        for (int i = 1; i <= index; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix[index];
    }

    public int sumRange(int left, int right) {
        return getPrefixSum(right) - getPrefixSum(left);
    }


}
