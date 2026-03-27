package Graphs.SCG;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {

    public int kosaraju(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            rev.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < V ; i++){
            if(visited[i])continue;
            dfsRegular(graph,visited,i,stack);
        }
        int count = 0 ;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node])continue;
            dfsReversed(rev,visited,node);
            count++;
        }
        return count;
    }
    public void dfsReversed(List<List<Integer>> graph,boolean[] visited,int node){
        if(!visited[node])return;
        visited[node] =false;

        for(int nei : graph.get(node)){
            dfsReversed(graph,visited,nei);
        }
    }
    public void dfsRegular(List<List<Integer>> graph,boolean[] visited,int node,Stack<Integer> stack){
        if(visited[node])return;
        visited[node] = true;
        for(int nei : graph.get(node)){
            dfsRegular(graph,visited,nei,stack);
        }
        stack.push(node);
    }
}
