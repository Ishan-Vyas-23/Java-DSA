package Graphs.DFS;
import java.util.*;

public class DFS_Recursive {
    static int n = 6;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        System.out.println(dfs(graph));
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static List<Integer> dfs(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> res = new ArrayList<>();
        dfsRec(graph, visited, 0, res);
        return res;
    }
    //we simply pass parameters as dfs(nested list as graph , visited array , source , result list)
    static void dfsRec(List<List<Integer>> graph, boolean[] visited, int source, List<Integer> res) {
        visited[source] = true;
        res.add(source);

        // Recursively visit all adjacent vertices
        // that are not visited yet
        for (int neighbour : graph.get(source)) {
            if (!visited[neighbour]) {
                dfsRec(graph, visited, neighbour, res);
            }
        }
    }
}
