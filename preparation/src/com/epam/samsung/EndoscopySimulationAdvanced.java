package com.epam.samsung;

import java.util.*;

/*Company S has developed an industrial endoscope available to explore inner part of the decrepit water pipes.
It is possible to explore the inner part of the pipes putting the endoscope in a certain part of the pipe.
The endoscope can be moved in the pipe only. Meanwhile, when the pipes are connected, if the length of the endoscope is
long enough to explore, then it can inspect the connected pipes. However, we cannot observe every pipe because the length of the endoscope is limited.
When the map of the ground water pipe, the location where the endoscope to out in, and the length of the endoscope is given,
calculate the number of pipe which are available to explore. Length of endoscope means the range upto which endoscope can explore.
There are seven kind of pipes, and description for each pipe are shown below:

S.No	Pipe	Connected to
1		Up, Down, Left, Right
2		Up, Down
3		Left, Right
4		Up, Right
5		Down, Right
6		Down, Left
7		Up, Left
When the map of the groundwater pipe, the location where the endoscope to out in, and the length of the endoscope is given,
calculate the number of the pipe which are available to explore. Length of endoscope means the range up to which endoscope can explore.*/
public class EndoscopySimulationAdvanced {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Map<Integer, boolean[]> pipeMap = new HashMap<>();
    static {
        pipeMap.put(1, new boolean[]{true, true, true, true}); // up, down, left, right
        pipeMap.put(2, new boolean[]{true, true, false, false});
        pipeMap.put(3, new boolean[]{false, false, true, true});
        pipeMap.put(4, new boolean[]{true, false, false, true});
        pipeMap.put(5, new boolean[]{false, true, false, true});
        pipeMap.put(6, new boolean[]{false, true, true, false});
        pipeMap.put(7, new boolean[]{true, false, true, false});
    }
    static int[] opposite = {1, 0, 3, 2};
    public static int explorePipes(int[][] grid, int startX, int startY, int maxLength){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, maxLength});
        visited[startX][startY] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[0];
            int length = current[0];

            if(length >= maxLength) continue;

            int pipeType = grid[x][y];
            if(!pipeMap.containsKey(pipeType)) continue;

            boolean[] directions = pipeMap.get(pipeType);
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && pipeMap.containsKey(grid[nx][ny])){
                    int nextPipe = grid[nx][ny];

                    // Check if movement is possible from current pipe to next pipe
                    if(directions[i] && pipeMap.get(nextPipe)[opposite[i]]){
                        queue.add(new int[]{nx, ny, length+1});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
