package Sliding_Window.Problems;

import java.util.HashMap;

public class maxErasureValue {

//https://leetcode.com/problems/maximum-erasure-value/
    public int maximumUniqueSubarray(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0 ;
        int left = 0 ;
        int sum  = 0 ;
        for(int i = 0 ; i < arr.length ;i++ ){
            if(map.containsKey(arr[i])){
                max = Math.max(max,sum);
                while(left < map.get(arr[i]) + 1 ){
                    sum = sum - arr[left];
                    left++;
                }

            }
            sum = sum + arr[i];
            map.put(arr[i],i);
        }
        return Math.max(sum,max);
    }

}
