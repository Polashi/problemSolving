package com.epam.trie;

public class WordDictionary {
    class Node{
        Node[] links;
        boolean end;
        Node(){
            links = new Node[26];
            end = false;
        }
        boolean containsKey(char ch){
            return (links[ch-'a'] != null);
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        boolean isEnd(){
            return end;
        }
        void setEnd(){
            end = true;
        }

    }

    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }else{
                node = node.get(ch);
            }
        }
        return true;
    }
}
