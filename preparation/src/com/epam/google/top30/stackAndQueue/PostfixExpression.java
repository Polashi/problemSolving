package com.epam.google.top30.stackAndQueue;

import java.util.Stack;

public class PostfixExpression {
    public static void main(String[] args) {
        System.out.println(getPostfixExpressionValue("52+83-*"));
    }
    public static int getPostfixExpressionValue(String expression){
        Stack<Integer> stack = new Stack<>();
        for(char ch: expression.toCharArray()){
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }else{
                int b = stack.pop();
                int a = stack.pop();
                switch (ch){
                    case '+' : stack.push(a+b); break;
                    case '-' : stack.push(a-b); break;
                    case '*' : stack.push(a*b); break;
                    case '/' : stack.push(a/b); break;
                }
            }
        }
        return stack.pop();
    }
}
