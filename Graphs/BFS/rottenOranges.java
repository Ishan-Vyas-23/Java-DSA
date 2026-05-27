package Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class rottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int n = grid.length;
        int m= grid[0].length;
        int fresh = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0 ;

        while(!q.isEmpty() && fresh > 0 ){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                int [] curr = q.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                if(isSafe(grid,currRow-1,currCol,n,m)){
                    grid[currRow-1][currCol] = 2 ;
                    fresh--;
                    q.offer(new int[]{currRow-1,currCol});
                }
                if(isSafe(grid,currRow+1,currCol,n,m)){
                    grid[currRow+1][currCol] = 2 ;
                    fresh--;
                    q.offer(new int[]{currRow+1,currCol});
                }
                if(isSafe(grid,currRow,currCol-1,n,m)){
                    grid[currRow][currCol-1] = 2 ;
                    fresh--;
                    q.offer(new int[]{currRow,currCol-1});
                }
                if(isSafe(grid,currRow,currCol+1,n,m)){
                    grid[currRow][currCol + 1] = 2 ;
                    fresh--;
                    q.offer(new int[]{currRow,currCol+1});
                }
            }
            time++;
        }

        if(fresh > 0 )return -1;

        return time;
    }
    public boolean isSafe(int[][] grid,int row , int col , int rowLen , int colLen){
        if(row < 0 || row >= rowLen)return false;
        if(col < 0 || col >= colLen)return false;

        if(grid[row][col] == 1)return true;

        return false;
    }
}
