package com.epam.google.graph;

import java.util.ArrayList;
import java.util.List;

public class MakeNetworkConnected {
    class DisjointSet {
        int[] parents;
        int[] sizes;
        DisjointSet(int V){
            parents = new int[V];
            sizes = new int[V];
            for(int i=0; i<V; i++){
                parents[i] = i;
                sizes[i] = 1;
            }
        }
        int findUParent(int node){
            if(parents[node] == node){
                return node;
            }
            int ult_parent = findUParent(node);
            parents[node]= ult_parent;
            return ult_parent;
        }

        void unionBySize(int u, int v){
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);
            if(ulp_u == ulp_v){
                return;
            }
            if(sizes[ulp_u] < sizes[ulp_v]){
                parents[ulp_u] = ulp_v;
                sizes[ulp_v] += sizes[ulp_u];
            }else{
                parents[ulp_v] = ulp_u;
                sizes[ulp_u] += sizes[ulp_v];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int countExtraEdge = 0;
        int m = connections.length;
        for(int i=0; i<m; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(disjointSet.findUParent(u) == disjointSet.findUParent(v)){
                countExtraEdge++;
            }else{
                disjointSet.unionBySize(u,v);
            }
        }
        int comp = 0;
        for(int i=0;i<n; i++){
            if(disjointSet.parents[i]== i){
                comp++;
            }
        }
        int requiredEdge = comp-1;
        if(countExtraEdge >= requiredEdge){
            return requiredEdge;
        }
        return -1;
    }
}
