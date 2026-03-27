package Graphs.MST.problems;

import java.util.PriorityQueue;

public class costConnectingPoints {

//https://leetcode.com/problems/min-cost-to-connect-all-points/
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q.offer(new int[]{0,0});
        int sum = 0 ;
        int n = points.length;
        boolean [] visited = new boolean[n];
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int currIndex = curr[0];
            int currWt = curr[1];

            if(visited[currIndex])continue;
            visited[currIndex] = true;
            sum += currWt;

            for(int i = 0 ; i < n ; i++){
                if(!visited[i]){
                    int cost = Math.abs(points[i][1] - points[currIndex][1]) + Math.abs(points[i][0] - points[currIndex][0]);
                    q.offer(new int[]{i,cost});
                }
            }
        }
        return sum;
    }
}
