package Graphs.cycleDetectionMethods;

import java.util.ArrayList;
import java.util.Collections;

public class topologicalSort {

    //https://www.geeksforgeeks.org/problems/topological-sort/1
    //for a directed acyclic graph
    public ArrayList<Integer> topoSort(int v, int[][] edges) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] e : edges){
            graph.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[v];

        for(int i = 0 ; i< graph.size() ;i++){
            if(!visited[i]){
                topSorter(graph,i,visited,list);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public void topSorter(ArrayList<ArrayList<Integer>> graph ,int node, boolean [] visited,ArrayList<Integer> list ){
        if(visited[node])return;

        visited[node] = true;

        for(int neighbor : graph.get(node)){
            topSorter(graph,neighbor,visited,list);
        }

        list.add(node);
    }
}
