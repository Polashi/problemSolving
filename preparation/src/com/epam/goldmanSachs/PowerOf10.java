package com.epam.goldmanSachs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOf10 {
    public static void main(String[] args) {

    }
    public static boolean isPowerOfTen(int number){
        if(number <= 0){
            return false;
        }
        while(number %10 == 0){
            number = number/10;
        }
        return (number == 1);
    }

    @Test
    public void testPowerOfTen(){
        assertTrue(isPowerOfTen(0));
        assertFalse(isPowerOfTen(7));
    }
}
