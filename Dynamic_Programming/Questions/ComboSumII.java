package Dynamic_Programming.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/

// here too like comboSum I , DP is not that effective 
public class ComboSumII {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(candidates.length == 0  || target == 0)return res;

        List<Integer> list = new ArrayList<>();

        // sort the array first to get the result lists sorted
        Arrays.sort(candidates);

        helper(candidates,target  , list , 0);
        return res;
    }

    public void helper(int[] arr , int target , List<Integer> list , int index ){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(index >= arr.length ){
            return;
        }

        // as the array is sorted if the element is already bigger than target just return
        if (arr[index] > target) return;

        // we either take the element and backtrack
        list.add(arr[index]);
        helper(arr,target - arr[index] , list , index+1);
        list.removeLast();

        //we skip duplicates

        int next = index +1;
        while(next < arr.length && arr[next] == arr[index] ){
            next++;
        }
        // or we skip it
        helper(arr,target,list,next);
    }

}
