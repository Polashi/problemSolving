package com.epam.google.top30.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node{
        int value;
        List<Node> neighbors;
        Node(int value){
            this.value = value;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node){
        if(node == null){
            return node;
        }
        Map<Node,Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }
    private static Node cloneNode(Node node, Map<Node, Node> visited){
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node clone = new Node(node.value);
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(cloneNode(neighbor, visited));
        }
        return clone;
    }
}
