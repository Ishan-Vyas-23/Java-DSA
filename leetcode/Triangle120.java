package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(5,7,6));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(list));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0 ;
        for (List<Integer> list : triangle){
            sum = sum + minFromList(list);
        }
        return sum;
    }
    public static int minFromList(List<Integer> list){
        int min  = list.get(0);
        for(int i = 1 ; i < list.size() ; i++){
            min = Math.min(min,list.get(i));
        }
        return min;
    }
}
