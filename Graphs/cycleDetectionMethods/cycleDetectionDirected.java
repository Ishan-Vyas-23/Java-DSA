package Graphs.cycleDetectionMethods;

import java.util.ArrayList;
import java.util.List;

public class cycleDetectionDirected {

    //https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
    public boolean isCyclic(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < v ;i++)
            graph.add(new ArrayList<>());

        for(int [] e : edges)
            graph.get(e[0]).add(e[1]);

        boolean [] visited = new boolean[v];
        boolean [] rec = new boolean[v]; // keeps track of nodes in current recursion stack

        for(int i = 0 ; i < v ; i++)
            if(!visited[i] && detectCycle(graph,i,visited,rec))
                return true;

        return false;
    }

    public boolean detectCycle(List<List<Integer>> graph , int node , boolean[] visited,boolean[] rec){
        if(rec[node])return true;
        if(visited[node])return false;

        visited[node] = true;
        rec[node] = true;

        for(int neighbor : graph.get(node))
            if(detectCycle(graph, neighbor, visited, rec))
                return true;

        //backtrack
        rec[node] = false;

        return false;
    }

//using topological sort , is the topologically sorted list size is not equal to number of vertices then a cycle is present

}
