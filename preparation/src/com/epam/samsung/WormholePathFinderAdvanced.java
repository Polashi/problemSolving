package com.epam.samsung;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WormholePathFinderAdvanced {
    public static int findPathCost(int sx, int sy, int dx, int dy, int[][] wormholes){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> distnaceMap = new HashMap<>();
        pq.add(new Node(sx, sy, 0));
        distnaceMap.put(String.valueOf(sx + ',' + sy), 0);

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int x = current.source;
            int y = current.destination;
            int cost = current.cost;
            if(x == dx && y == dy){
                return cost;
            }
            int totalCost = Math.abs(x-dx) + Math.abs(y-dy);
            String key = String.valueOf(dx + ',' + dy);
            if(!distnaceMap.containsKey(key) || cost + totalCost < distnaceMap.get(key)){
                distnaceMap.put(key, cost+totalCost);
                pq.add(new Node(dx, dy, cost + totalCost));
            }

            for(int[] hole : wormholes){
                int x1 = hole[0];
                int y1 = hole[1];
                int x2 = hole[2];
                int y2 = hole[3];
                int holeCost = hole[4];

                if((x==x1 && y==y1) || (x==x2 && y==y2)){

                }

            }
        }
        return 0;
    }

    private static class Node implements Comparable<Node>{
        int source;
        int destination;
        int cost;

        public Node(int cost, int destination, int source) {
            this.cost = cost;
            this.destination = destination;
            this.source = source;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
}

