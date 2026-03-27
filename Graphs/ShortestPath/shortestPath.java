package Graphs.ShortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class shortestPath {
    public static int shortestPathAlgo(int n, int[][] edges, int nodeA, int nodeB) {
        if (nodeA == nodeB) return 0;

        // 1) build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[n];

        // we used an ArrayDequeue for performance
        // we could have also used a LinkedList time complexity will remain the same
        // ArrayDequeue uses dynamic circular queue which is better than a linkedList in memory performance
        Queue<int[]> queue = new ArrayDeque<>(); // store {node, distance}

        visited[nodeA] = true;
        queue.offer(new int[]{nodeA, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int dist = cur[1];

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    if (nei == nodeB) return dist + 1; // found shortest path
                    visited[nei] = true;
                    queue.offer(new int[]{nei, dist + 1});
                }
            }
        }

        return -1; // unreachable
    }

    // simple test
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(shortestPathAlgo(n, edges, 0, 2)); // should print 1 (edge 0-2)
        System.out.println(shortestPathAlgo(n, edges, 0, 1)); // should print 1
        System.out.println(shortestPathAlgo(n, edges, 1, 1)); // 0 (same node)
    }
}
