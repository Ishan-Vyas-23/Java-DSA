package Dynamic_Programming.Questions;

import java.util.HashMap;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(5));

    }

    HashMap<Integer , Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n <2){
            return 1;
        }
        int left = climbStairs(n-1);
        int right = climbStairs(n-2);
        map.put( n , left + right);
        return left + right ;
    }
}
