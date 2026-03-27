package Sliding_Window.Problems;

import java.util.ArrayList;
import java.util.Set;

public class CountDistinct {

    public static void main(String[] args) {
        int [] arr = {1 ,2, 1, 3, 4 ,2 ,3};
        System.out.println(countDistinct(arr,4));
    }
//https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
    public static  ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        java.util.HashMap<Integer,Integer> map = new java.util.HashMap<>();

        for(int i = 0 ; i < k ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        list.add(map.size());
        for(int i = k ; i < arr.length ;i++){
            int leaving = arr[i-k];
            int entering = arr[i];
            map.put(entering,map.getOrDefault(entering,0)+1);
            java.util.Set<Integer> keys = map.keySet();
            int count = map.get(leaving) - 1;
            if (count == 0) {
                map.remove(leaving);
            } else {
                map.put(leaving, count);
            }

            list.add(map.size());
        }
        return list ;
    }
}
