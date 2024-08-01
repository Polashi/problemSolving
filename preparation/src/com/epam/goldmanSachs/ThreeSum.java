package com.epam.goldmanSachs;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getTriplets(int[] nums){
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if(set.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    ans.add(temp);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(ans);
        return list;
    }
}
