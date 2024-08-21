package com.epam.google;

public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(input));
    }
    public static int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] stack = new int[parts.length+1];
        int maxLength = 0;
        for (String s : parts) {
            int lev = s.lastIndexOf("\t") + 1;
            int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")){
                maxLength = Math.max(maxLength, curLen - 1);
            }
        }
        return maxLength;
    }
}
