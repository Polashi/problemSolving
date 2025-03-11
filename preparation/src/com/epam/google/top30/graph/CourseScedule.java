package com.epam.google.top30.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            indegree[p[0]]++;
            list.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int i: list.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
        }
        return (count == numCourses);
    }
}
