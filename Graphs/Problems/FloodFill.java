package Graphs.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

//https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        int [][] dirs = { {-1,0} , {0,-1} , {0,1} , {1,0} };

        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();

        rowQ.offer(sr);
        colQ.offer(sc);

        int rowLen = image.length;
        int colLen = image[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
        while(!rowQ.isEmpty()){
            int row = rowQ.poll();
            int col = colQ.poll();
            visited[row][col] = true;
            if(image[row][col] == target){
                image[row][col] = color;
            }

            for(int [] dir : dirs){
                int x = row + dir[0];
                int y = col + dir[1];
                if( x < 0 || y < 0 || x >= rowLen || y>= colLen || visited[x][y])continue;
                if(image[x][y] == target){
                    rowQ.offer(x);
                    colQ.offer(y);
                }
            }

        }

        return image;
    }

}
