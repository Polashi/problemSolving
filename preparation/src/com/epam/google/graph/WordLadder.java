package com.epam.google.graph;

import java.util.*;

public class WordLadder {
    class Pair{
        String word;
        int level;
        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        set.add(beginWord);
        while(!queue.isEmpty()){
            String word = queue.peek().word;
            int steps = queue.peek().level;
            queue.poll();
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String replacedString = new String(charArray);
                    if (set.contains(new String(replacedString))){
                        set.remove(replacedString);
                        queue.add(new Pair(replacedString, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
