package com.epam.trie;

public class MaxXORTwoNumbers {
    class Node {
        Node[] links;

        Node() {
            links = new Node[2];
        }

        boolean containsKey(int bit) {
            return (links[bit] != null);
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }

        Node get(int bit) {
            return links[bit];
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }
    }
    public int getMaxXOR(int num){
        Trie trie = new Trie();
        Node node = trie.root;
        int max = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1-bit)){
                max |= (1<< i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return max;
    }
}
