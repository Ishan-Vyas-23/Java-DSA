package Graphs.MST;
import java.util.*;

public class Prims {

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
    // if we have to also return the resulting MST i.e a list of edges in the MST ,\
    // we can keep a track of parent in the min heap and add the edge when not visited
    public int spanningTree(int v, int[][] edges) {

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < v ; i++)graph.add(new ArrayList<>());

        for(int [] e : edges){
            graph.get(e[0]).add(new int[]{e[1],e[2]});
            graph.get(e[1]).add(new int[]{e[0],e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1] );

        boolean [] visited = new boolean[v];
        pq.offer(new int[]{0,0});

        int sum = 0 ;

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int wt = curr[1];
            int node  = curr[0];

            if(visited[node])continue;

            visited[node] = true;
            sum += wt;

            for(int [] currNode : graph.get(node)){
                int currWt = currNode[1];
                int currNodeVal = currNode[0];
                if(!visited[currNodeVal]){
                    pq.offer(new int[]{currNodeVal,currWt});
                }
            }

        }
        return sum;
    }
}
