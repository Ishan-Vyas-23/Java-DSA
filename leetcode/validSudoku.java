package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class validSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        List<HashSet<Integer>> sub = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            sub.add(new HashSet<>());
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                char ch = board[i][j];
                if(ch == '.')continue;
                int val = ch - '0';

                if(rows.get(i).contains(val))return false;
                rows.get(i).add(val);

                if(cols.get(j).contains(val))return false;
                cols.get(j).add(val);

                int index = (i / 3) * 3 + (j / 3);

                if(sub.get(index).contains(val))return false;
                sub.get(index).add(val);

            }
        }
        return true;
    }
}
