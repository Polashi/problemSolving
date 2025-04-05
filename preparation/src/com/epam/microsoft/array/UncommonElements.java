package com.epam.microsoft.array;

import java.util.HashMap;
import java.util.Map;

public class UncommonElements {
    public int getSum(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return -1;
        }
        int n = arr1.length;
        int m = arr2.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }

        for (int i = 0; i < n; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                sum+= entry.getKey();
            }
        }
        return sum;
    }
}
