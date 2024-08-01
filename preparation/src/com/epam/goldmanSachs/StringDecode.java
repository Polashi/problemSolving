package com.epam.goldmanSachs;

import java.util.Stack;

public class StringDecode {
    public static void main(String[] args) {
        String str = "2[ab]3[c]";
        System.out.println(decode("2[abc]3[cd]ef"));
    }
    public static String decode(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Stack<StringBuilder> string_stack = new Stack<>();
        Stack<Integer> count_stack = new Stack<>();

        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)){
                count = count*10 + (ch - '0'); //2
            }else if(ch == '['){
                count_stack.push(count);
                count = 0;
                string_stack.push(sb);
                sb = new StringBuilder();
            }else if(ch == ']'){
                int curr_count = count_stack.pop();
                StringBuilder temp = sb;
                sb = string_stack.pop();
                while (curr_count >0){
                    sb.append(temp);
                    curr_count--;
                }
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
