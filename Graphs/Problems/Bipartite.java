package Graphs.Problems;

public class Bipartite {

//https://leetcode.com/problems/is-graph-bipartite/
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean [] visited = new boolean[n];
        int [] color = new int[n]; // color 1 or color 2

        for(int i = 0 ; i < n ; i++){
            if(!visited[i] && !dfs(graph,visited,color,i,1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,boolean[] visited,int[] color,int node,int curr){
        if(visited[node])return true;

        visited[node] = true;

        color[node]=curr;

        for(int nei : graph[node]){
            if(color[nei] == color[node])return false;
            if(curr == 1){
                if(!dfs(graph,visited,color,nei,2))return false;
            }else{
                if(!dfs(graph,visited,color,nei,1))return false;
            }
        }
        return true;
    }
}
