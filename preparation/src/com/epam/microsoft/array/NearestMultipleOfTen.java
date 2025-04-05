package com.epam.microsoft.array;

public class NearestMultipleOfTen {
    public static int nearestMultiple(int num){
        int a = (num/10) * 10;
        int b = a + 10;

        return (num-a >= b-num) ? b : a;
    }
}
