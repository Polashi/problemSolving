package com.epam.google.top30.stackAndQueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue(){
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        transferElements();
        return outputStack.pop();
    }
    private void transferElements(){
        if (outputStack.empty()){
            while (!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
    }

    public int peek() {
        transferElements();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.empty();
    }
}
