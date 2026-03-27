package Graphs.DFS;

public class wordFinder {

//https://leetcode.com/problems/word-search/?envType=problem-list-v2&envId=depth-first-search
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n =board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == word.charAt(0) ){
                    boolean val = dfs(board,i,j,visited,0,word,m,n);
                    if(val){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char [][] board,int r,int c,boolean[][] visited,int index,String word,int row , int col ){
        char ch = word.charAt(index);
        if(ch != board[r][c])return false;

        if(index == word.length()-1)return true;

        visited[r][c] = true;

        if(r > 0 && !visited[r-1][c] ){
            if(dfs(board,r-1,c,visited,index+1,word,row,col)){
                return true;
            }
        }
        if(c > 0 && !visited[r][c-1]  ){
            if(dfs(board,r,c-1,visited,index+1,word,row,col)){
                return true;
            }
        }
        if(r < row-1 && !visited[r+1][c]  ){
            if(dfs(board,r+1,c,visited,index+1,word,row,col)){
                return true;
            }
        }
        if(c < col-1 && !visited[r][c+1]  ){
            if(dfs(board,r,c+1,visited,index+1,word,row,col)){
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
