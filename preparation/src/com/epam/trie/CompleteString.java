package com.epam.trie;

public class CompleteString {
    class Node {
        Node[] links;
        boolean flag;

        Node() {
            links = new Node[26];
            flag = false;
        }

        boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        void put(char ch, Node node) {
            if (!containsKey(ch)) {
                links[ch - 'a'] = node;
            }
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        boolean checkIfPrefixExists(String str) {
            int n = str.length();
            Node node = root;

            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    if (!node.isEnd()) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
    }

    public String completeString(int n, String[] arr) {
        Trie trie = new Trie();
        for (String str : arr) {
            trie.insert(str);
        }
        String longest = "";
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            if (trie.checkIfPrefixExists(str)) {
                if (str.length() > longest.length() || str.length() == longest.length() && str.compareTo(longest) < 0) {
                    longest = str;
                }
            }
        }
        if (longest == "") {
            return "None";
        }
        return longest;
    }


}
