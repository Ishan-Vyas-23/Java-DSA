package Dynamic_Programming.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {

// https://leetcode.com/problems/combination-sum/

    // simple without DP
    public static void main(String[] args) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();

        int [] arr = new int[30];
        for (int i = 0 ; i < 30 ; i++){
            arr[i] = i+1 ;
        }
        System.out.println(combinationSum(arr,7));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0  || target == 0)return res;
        List<Integer> list = new ArrayList<>();
        helper(candidates,target  , list , 0);
        return res;
    }
    public static void helper(int[] arr , int target , List<Integer> list , int start){
        if(target == 0 ){
            // we dont add the reference of the list as it ends empty [] list at the end
            res.add(new ArrayList<>(list));
            return ;
        }
        if(target < 0 ){
            return ;
        }

        // use start so to avoid duplicates like [2,3,2] and [3,2,2]
        for(int i = start ; i < arr.length ; i++){
            list.add(arr[i]);
            helper(arr, target - arr[i],list , i);
            list.removeLast();
        }
    }

    // recursive DP
    // here DP is actually not that good because most of the recursion calls are unique so there isn't much to remember

    List<List<Integer>> resDP = new ArrayList<>();
    Map<String , List<Integer> > map = new HashMap<>();
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        if(candidates.length == 0  || target == 0)return res;
        List<Integer> list = new ArrayList<>();
        helperDP(candidates,target  , list , 0);
        return res;
    }
    public void helperDP(int[] arr , int target , List<Integer> list , int start){
        if(target == 0 ){
            res.add(new ArrayList<>(list));
            return ;
        }
        if(target < 0 ){
            return ;
        }

        String key = target + "+" + start + list.toString();
        if(map.containsKey(key)){
            return;
        }

        map.put(key,new ArrayList<>());

        for(int i = start ; i < arr.length ; i++){
            list.add(arr[i]);
            helperDP(arr, target - arr[i],list , i);
            list.removeLast();
        }
    }


}
