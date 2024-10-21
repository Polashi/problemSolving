package com.epam.google;

public class KEmptySlots {
    public static void main(String[] args) {
        System.out.println(kEmptySlots(new int[]{1, 3, 2}, 1));
    }

    public static int kEmptySlots(int[] bulbs, int K){
        int n=bulbs.length;
        int position[]=new int[n+1];
        for(int i=0;i<n;i++) position[bulbs[i]]=i+1;
        int result=Integer.MAX_VALUE;
        int start=1,end=K+2;
        for(int i=1; end<=n; i++)
        {
            if(position[i]>position[start] && position[i]>position[end]) continue;
            if(i==end) result=Math.min(result,Math.max(position[start],position[end]));
            start=i;
            end=i+K+1;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
