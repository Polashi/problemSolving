package com.epam.goldmanSachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFrequentIPAddress {
    public static void main(String[] args) {
        String[] ips = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"};
    }
    public List<String> mostFrequentIP(String[] ipAddresses){
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: ipAddresses){
            String[] str_arr = str.split(" "); // {"10.0.0.2", "-", "GET" ,"2020-08-20"}
            map.put(str_arr[0], map.getOrDefault(str_arr[0],0)+1);
        }
        List<String> mostFrequent = new ArrayList<>();
        int max_freq = 0;
        for(String str : map.keySet()){
            if(map.get(str) >= max_freq){
                max_freq = map.get(str);
            }
        }

        for(String ip: map.keySet()){
            if(map.get(ip) == max_freq){
                mostFrequent.add(ip);
            }
        }
        return mostFrequent;

    }
}
