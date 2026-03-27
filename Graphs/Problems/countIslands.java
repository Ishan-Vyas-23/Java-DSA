package Graphs.Problems;

public class countIslands {

//https://leetcode.com/problems/number-of-islands/

    // just a regular counting connected components graph problem with 4 neighbors to each node
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 ||
                row >= grid.length || col >= grid[0].length ||
                grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        // instead of manual calling 4 recursions we use dirs array
        // if diagonal path allowed {-1,-1} and {1,1} add in the dirs
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] d : dirs) {
            dfs(grid, visited,row + d[0], col + d[1]);
        }
    }

}
