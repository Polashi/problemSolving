package com.epam.goldmanSachs;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }
    public static int[] getNGE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for(int i=2*n-1; i>=0; i--){
            while(!stack.isEmpty() || stack.peek() <= arr[i%n]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    nge[i] = stack.peek();
                }else{
                    nge[i] = -1;
                }
            }
            stack.push(arr[i%n]);
        }
        return nge;
    }
}
