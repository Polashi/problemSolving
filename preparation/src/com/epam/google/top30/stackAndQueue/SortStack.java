package com.epam.google.top30.stackAndQueue;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {

    }

    public static void sort(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    private static void insert(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
        }else {
            int top = stack.pop();
            insert(stack, element);
            stack.push(top);
        }
    }
}
