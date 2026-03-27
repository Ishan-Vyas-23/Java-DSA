package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral {

    public static void main(String[] args) {
        Spiral obj = new Spiral();
        int[][] matrix =obj.generateMatrix(3);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }

//https://leetcode.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        int  m = matrix.length ;
        int n = matrix[0].length;
        int count = m*n;
        List<Integer> list = new ArrayList<>();
        int top = 0 ;
        int bottom = m -1;
        int right = n -1;
        int left = 0 ;
        while(left <= right && top <= bottom){
            //right
            for(int i = left ; i <= right ; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            //down
            for(int i = top ; i <= bottom ; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            //left
            for(int i = right ; i >= left ; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;
            //up
            for(int i = bottom ; i >= top ; i--){
                list.add(matrix[i][left]);
            }
            left++;

        }
        return list;
    }

//https://leetcode.com/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int top = 0 ;
        int bottom = n -1;
        int right = n -1;
        int left = 0 ;
        int num = 1;
        int[][] matrix = new int [n][n];
        while(left <= right && top <= bottom){
            //right
            for(int i = left ; i <= right ; i++){
                matrix[top][i] = num;
                num++;
            }
            top++;
            if (top > bottom) break;
            //down
            for(int i = top ; i <= bottom ; i++){
                matrix[i][right] = num;
                num++;
            }
            right--;
            if (left > right) break;
            //left
            for(int i = right ; i >= left ; i--){
                matrix[bottom][i] = num;
                num++;
            }
            bottom--;
            if (top > bottom) break;
            //up
            for(int i = bottom ; i >= top ; i--){
                matrix[i][left] = num;
                num++;
            }
            left++;

        }
        return matrix;
    }

}
