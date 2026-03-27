package Subsets;

import java.util.ArrayList;
import java.util.List;

public class comboSumIII {
    public static void main(String[] args) {
        comboSumIII obj = new comboSumIII();
        System.out.println(obj.combinationSum3(3,7));
    }

//https://leetcode.com/problems/combination-sum-iii/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int max = Math.min(9,n);
        helper(1,max,n,k,list,res);
        return res;
    }
    public void helper( int sum,int max , int target ,int k , List<Integer> list,List<List<Integer>> res ){
        if(target == 0 && k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || k < 0){
            return ;
        }
        if( sum > max || sum > target){
            return;
        }
        list.add(sum);
        helper(sum+1,max,target-sum,k-1,list,res);
        list.removeLast();
        helper(sum+1,max,target,k,list,res);
    }
}
