package com.epam.google;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FruitIntoBasket {
    public static void main(String[] args) {

    }

    public static int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;

        }
        return maxLength;
    }
}
