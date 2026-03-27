package Dynamic_Programming.Questions;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {

    }

    // recursive DP
    HashMap<Integer,Integer> map = new HashMap<>();
    public int robDP(int[] arr) {
        return helper(arr,0);
    }
    public int helper(int [] arr , int index){
        if(index >= arr.length){
            return 0 ;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int a = helper(arr,index+2) ;
        int b = helper(arr,index+1);
        map.put(index, Math.max(arr[index] + a , b));
        return map.get(index);
    }

    //brute
    int max  = Integer.MIN_VALUE;
    public int rob(int[] arr) {
        helper(arr,0,0);
        return max;
    }
    void helper(int [] arr , int index , int sum){
        if(index >= arr.length ){
            max = Math.max(max,sum);
            return;
        }
        helper(arr,index+2,sum+arr[index]);
        helper(arr,index+1,sum);
    }

}
