package com.epam.trie;

public class PrefixTrie {
    class Node{
        Node[] links;
        int countEnd;
        int countStart;

        Node(){
            links = new Node[26];
            countEnd = 0;
            countStart= 0;
        }

        boolean containsKey(char ch){
            return (links[ch - 'a'] != null);
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }
        Node get(char ch){
            return links[ch - 'a'];
        }
        void increaseEnd(){
            countEnd++;
        }
        void increaseStart(){
            countStart++;
        }
        void reduceEnd(){
            countEnd--;
        }
        void reduceStart(){
            countEnd--;
        }

    }
    private Node root;

    PrefixTrie(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increaseStart();
        }
        node.increaseEnd();
    }

    int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.countEnd;
    }

    int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.countStart;
    }
    void erase(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return;
            }
            node = node.get(ch);
            node.reduceStart();
        }
        node.reduceEnd();
    }

}
