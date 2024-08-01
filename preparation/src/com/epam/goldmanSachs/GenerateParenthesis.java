package com.epam.goldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, n, n, "");
        return ans;
    }

    private static void generate(List<String> ans, int open ,int close, String output){
        if(open == 0 && close == 0){
            ans.add(output);
            return;
        }
        if(open> 0) {
            generate(ans, open-1, close, output + "(");
        }
        if(close > open){
            generate(ans, open, close-1, output + ")");
        }

    }
}
