package PrefixSum;

import java.util.HashMap;

public class contigousArray {

//https://leetcode.com/problems/contiguous-array/description/
    public int findMaxLength(int[] arr) {
        int sum = 0 ;
        int res = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0 ){
                sum -= 1;
            }else{
                sum += 1;
            }
            if(map.containsKey(sum)){
                res = Math.max(res,i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return res;
    }
}
