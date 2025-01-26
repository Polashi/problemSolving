package com.epam.trie;

public class CountDistinctSubstrings {
    class Node{
        Node[] links;
        Node(){
            links = new Node[26];
        }
        boolean containsKey(char ch){
            return (links[ch-'a'] != null);
        }
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
    }

    public int countDistinctSubstrings(String s)
    {
        Node root = new Node();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            Node node =  root;
            for(int j=0; j<s.length(); j++){
                if(!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j), new Node());
                    count++;
                }
                node = node.get(s.charAt(i));
            }
        }
        return count+1; // +1 for empty;

    }
}
