package Graphs.SCG;
import java.util.*;

// https://youtu.be/wUgWX0nc4NY?si=edZ1_6R0l7afW49_
// Tarjan's Algorithm Overview

// Step 1:
// Mark the id of each node as unvisited.

// Step 2:
// Start DFS traversal.
// When visiting a node:
//   - Assign it a unique id.
//   - Assign it a low-link value (initially same as id).
//   - Mark it as visited.
//   - Push it onto the stack (to track current path).

// Step 3:
// During DFS backtracking (callback phase):
//   - If the neighbor is still in the stack,
//     update current node's low-link value:
//       low[node] = min(low[node], low[neighbor])
//   - This helps propagate low-link values across cycles.

// Step 4:
// After visiting all neighbors:
//   - If current node is the start of a strongly connected component (SCC):
//       (i.e., id[node] == low[node])
//   - Then pop nodes from the stack until current node is reached.
//   - All popped nodes form one SCC.

// Note:
// low-link values help identify cycles and SCC roots.
// A node starts an SCC if its id equals its low-link value.

public class Tarjan {
    public static List<List<Integer>> tarjanSCC(List<List<Integer>> graph) {
        int n = graph.size();

        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] onStack = new boolean[n];
        Arrays.fill(ids, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> sccs = new ArrayList<>();

        int[] id = new int[]{0}; // mutable counter

        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i, graph, ids, low, onStack, stack, sccs, id);
            }
        }

        return sccs;
    }

    private static void dfs(int at, List<List<Integer>> graph, int[] ids, int[] low, boolean[] onStack, Deque<Integer> stack, List<List<Integer>> sccs, int[] id) {

        ids[at] = low[at] = id[0]++;
        stack.push(at);
        onStack[at] = true;

        for (int to : graph.get(at)) {
            if (ids[to] == -1) {
                dfs(to, graph, ids, low, onStack, stack, sccs, id);
                low[at] = Math.min(low[at], low[to]);
            } else if (onStack[to]) {
                low[at] = Math.min(low[at], ids[to]);
            }
        }

        // Root of an SCC
        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();

            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == at) break;
            }

            sccs.add(scc);
        }
    }
}
