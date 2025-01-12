package com.epam.google.graph;

import java.util.*;

public class AccountsMerge {
    class DisjointSet{
        int[] parents;
        int[] size;
        DisjointSet(int V){
            parents = new int[V];
            size = new int[V];
            for(int i=0; i<V; i++){
                parents[i] = i;
                size[i] = 1;
            }
        }
        int findUltimateParent(int node){
            if(node != parents[node]){
                int ulp = findUltimateParent(parents[node]);
                parents[node] = ulp;
                return ulp;
            }
            return node;
        }
        void union(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v){
                return;
            }
            if (size[ulp_u] < size[ulp_v]){
                parents[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else{
                parents[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> nodeMail = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!nodeMail.containsKey(mail)){
                    nodeMail.put(mail,i);
                }else {
                    disjointSet.union(i, nodeMail.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedMails[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> entry : nodeMail.entrySet()){
            String mail = entry.getKey();
            int node = disjointSet.findUltimateParent(entry.getValue());
            mergedMails[node].add(mail);
        }

        List<List<String>> finalList = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedMails[i].size() == 0){
                continue;
            }
            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: mergedMails[i]){
                temp.add(it);
            }
            finalList.add(temp);
        }
        return finalList;
    }
}
