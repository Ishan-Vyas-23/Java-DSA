package Graphs.ShortestPath;

import java.util.Arrays;

public class BellmanFord {

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
    public static int[] bellmanFord(int n, int[][] edges, int src) {
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i = 0 ; i < n ; i++){
            for(int [] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] == Integer.MAX_VALUE)continue;

                if(dist[u]+wt < dist[v]){

                    if(i == n-1){
                        return new int[]{-1};
                    }

                    dist[v] = dist[u]+wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };
        int src = 0;

        // Run Bellman-Ford algorithm from the source vertex
        int[] ans = bellmanFord(5, edges, src);

        // Print shortest distances from the source to all vertices
        for (int dist : ans)
            System.out.print(dist + " ");
    }
}
