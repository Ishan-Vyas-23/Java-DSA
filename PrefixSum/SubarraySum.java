package PrefixSum;

import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum obj = new SubarraySum();
        int [] arr = {1,34,42,5,2,5,2};
        System.out.println(obj.subarraySum(arr,1));
    }
//
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i = 0 ; i < arr.length ; i++){
            map.put(i+1,map.get(i)+arr[i]);
        }
        return map.getOrDefault(k,0);
    }



}
