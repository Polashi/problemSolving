package com.epam.google.top30.array;

import java.util.Arrays;

public class UniqueString {
    int MAX_CHAR = 256;

    boolean uniqueCharacters(String str)
    {
        // If length is greater than 256,
        // some characters must have been repeated
        if (str.length() > MAX_CHAR)
            return false;

        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        for (int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);
            if (chars[index] == true)
                return false;

            chars[index] = true;
        }

        return true;
    }

}
