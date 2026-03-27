package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int [] nums = {4,4};
        System.out.println(subsetsWithDup(nums));
    }

//https://leetcode.com/problems/subsets/
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums,0,list);
        return res;
    }
    public static void helper(int [] arr , int index , List<Integer> list){
        if(index == arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[index]);
        helper(arr,index+1,list);
        list.removeLast();
        helper(arr,index+1,list);
    }

//https://leetcode.com/problems/subsets-ii/
    static HashSet<List<Integer>> resSet = new HashSet<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper2(nums,0,list);
        return new ArrayList<>(resSet);
    }
    public static void helper2(int [] arr , int index , List<Integer> list){
        if(index == arr.length){
            resSet.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        helper2(arr,index+1,list);
        list.removeLast();
        helper2(arr,index+1,list);
    }


}

