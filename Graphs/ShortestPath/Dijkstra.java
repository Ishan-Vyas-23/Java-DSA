package Graphs.ShortestPath;
import java.util.*;

public class Dijkstra {

    //https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
    public int[] dijkstra(int v, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < v ; i++)graph.add(new ArrayList<>());

        for(int [] e : edges){
            graph.get(e[0]).add(new int[]{e[1],e[2]});
            graph.get(e[1]).add(new int[]{e[0],e[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] -b [1]);

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0 ;
        pq.offer(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            for(int[] neighbor : graph.get(node)){
                int neighborNode = neighbor[0];
                int neighborWt = neighbor[1];

                if(distance + neighborWt < dist[neighborNode]){
                    dist[neighborNode] = distance + neighborWt;
                    pq.offer(new int[]{neighborNode, dist[neighborNode]});
                }

            }

        }
        return dist;
    }

    //https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
    // printing shortest path => { 'total path weight' , path }
    public List<Integer> shortestPathPrint(int n, int m, int edges[][]) {

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for(int[] e : edges){
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1,0});
        dist[1] = 0;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;

            for(int[] nei : graph.get(node)){
                int next = nei[0];
                int wt = nei[1];

                if(d + wt < dist[next]){
                    dist[next] = d + wt;
                    parent[next] = node;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        if(dist[n] == Integer.MAX_VALUE)
            return Arrays.asList(-1);

        ArrayList<Integer> path = new ArrayList<>();
        int node = n;

        while(node != -1){
            path.add(node);
            node = parent[node];
        }

        path.add(dist[n]);
        Collections.reverse(path);
        return path;
    }


}
