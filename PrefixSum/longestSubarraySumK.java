package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class longestSubarraySumK {

//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
    public int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0 ;
        int sum = 0 ;
        map.put(0,-1);
        for(int i = 0 ; i < arr.length ;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                res = Math.max(res,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

        }
        return res;
    }
}
