package Graphs.Problems;

import java.util.ArrayList;
import java.util.List;

public class hasPath {

//https://leetcode.com/problems/find-if-path-exists-in-graph/?envType=problem-list-v2&envId=graph


    // this solution if for undirected graph , if the graph was directed
    // only change will be , we will add only one node for each node
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)graph.add(new ArrayList<>());

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        return helper(graph,source,destination,visited);
    }
    public boolean helper(List<List<Integer>> graph , int src , int dest ,boolean [] visited){
        if(src == dest)return true;

        visited[src]=true;

        for(int neighbour : graph.get(src)){
            if(visited[neighbour]){
                continue;
            }
            boolean res = helper(graph,neighbour,dest,visited);
            if(res){
                return true;
            }
        }
        return false;
    }

//https://leetcode.com/problems/all-paths-from-source-to-target/?envType=problem-list-v2&envId=graph
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int V = graph.length;
        list.add(0);
        dfs(graph,0,V-1,list,res);
        return res;
    }
    public void dfs(int[][] graph,int node,int dest,List<Integer> list,List<List<Integer>> res ){
        if(node == dest){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < graph[node].length ; i++){
            int nei = graph[node][i];
            list.add(nei);
            dfs(graph,nei,dest,list,res);
            list.remove(list.size()-1);
        }
    }
}
