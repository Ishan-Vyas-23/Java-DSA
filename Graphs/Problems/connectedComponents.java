package Graphs.Problems;

import java.util.ArrayList;
import java.util.List;

public class connectedComponents {

// counting number of connected components
    public int countConnectedComponents(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {

        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }  


//https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
    //printing connected components of graph
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i  < v ; i++)graph.add(new ArrayList<>());

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < graph.size() ; i++){
            if(!visited[i]){
                ArrayList<Integer> list = new ArrayList<>();
                helper(graph,i,visited,list);
                res.add(list);
            }
        }
        return res;

    }
    public void helper(ArrayList<ArrayList<Integer>> graph , int node , boolean[] visited , ArrayList<Integer> list){
        list.add(node);
        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                helper(graph,neighbour,visited,list);
            }
        }
    }


}
