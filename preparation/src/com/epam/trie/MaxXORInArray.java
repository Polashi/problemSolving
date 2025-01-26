package com.epam.trie;

public class MaxXORInArray {
    class Node{
        Node[] links;
        Node(){
            links = new Node[2];
        }
        boolean containsKey(int bit){
            return (links[bit] != null);
        }
        void put(int bit, Node node){
            links[bit] = node;
        }
        Node get(int bit){
            return links[bit];
        }
    }
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        void insert(int num){
            Node node = root;
            for(int i=31; i>=0; i--){
                int bit = (num >> i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }
        int maxNum(int num){
            Node node = root;
            int maxNum = 0;
            for(int i=31;i>=0; i--){
                int bit = (num >> i) & 1;
                if(node.containsKey(1-bit)){
                    maxNum |= (1<<i);
                    node = node.get(1-bit);
                }else{
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }
    public int getMaxXORBetweenTwoNumberInArray(int[] nums){
        Trie trie = new Trie();

        for(int num: nums){
            trie.insert(num);
        }
        int maxNum = 0;
        for(int num:nums){
            maxNum = Math.max(maxNum, trie.maxNum(num));
        }
        return maxNum;
    }
}
