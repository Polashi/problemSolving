package com.epam.google.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    int vertices;

    List<Integer> parents = new ArrayList<>();
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();

    public DisjointSet(int V){
        vertices = V;
        for(int i=0; i<V; i++){
            ranks.add(0);
            parents.set(i,i);
        }
    }

    public int findUltimateParent(int node){
        if(parents.get(node) == node){
            return node;
        }
        int ulp = findUltimateParent(parents.get(node));
        parents.set(node,ulp);
        return ulp;
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(ranks.get(ulp_u) < ranks.get(ulp_v)){
            parents.set(ulp_u, ulp_v);
        } else if (ranks.get(ulp_u) > ranks.get(ulp_v)) {
            parents.set(ulp_v,ulp_u);
        }else{
            parents.set(ulp_v, ulp_u);
            int rankU = ranks.get(ulp_u);
            ranks.set(ulp_u, rankU+1);
        }
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(sizes.get(ulp_u) < sizes.get(ulp_v)){
            sizes.set(ulp_u, ulp_v);
        }else if(sizes.get(ulp_u) > sizes.get(ulp_v)){
            sizes.set(ulp_v, ulp_u);
        }else{
            parents.set(ulp_u, ulp_v);
            int size = sizes.get(ulp_v);
            sizes.set(ulp_v, size+1);
        }

    }
    public void pathCompression(){

    }
}
