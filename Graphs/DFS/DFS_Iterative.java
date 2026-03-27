package Graphs.DFS;
import java.util.*;

public class DFS_Iterative {
    static int n = 6;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        System.out.println("DFS (Iterative) from node 0:");
        dfs(0);
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void dfs(int start) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            // A node might be pushed multiple times before being popped
            // so we check visited here, not before pushing
            if (visited[node]) continue;

            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }



}