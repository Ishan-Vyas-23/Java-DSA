package Graphs.cycleDetectionMethods;

import java.util.ArrayList;
import java.util.List;

public class cycleUndirected {

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> graph =new ArrayList<>();
        for(int i = 0 ; i  < V ; i++)graph.add(new ArrayList<>());
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!visited[i] && findCycle(graph,i,-1,visited)){
                return true;
            }
        }
        return false;
    }
    public boolean findCycle(List<List<Integer>> graph ,int node , int parent ,boolean[]visited){
        if(visited[node])return true;
        visited[node] = true;

        for(int neighbor : graph.get(node)){
            if(neighbor != parent && findCycle(graph,neighbor,node,visited)){
                return true;
            }
        }
        return false;
    }
}
