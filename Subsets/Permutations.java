package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int []arr = {1,2,3};
        System.out.println(obj.permute(arr).size());
    }

//https://leetcode.com/problems/permutations/description/
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> p = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        for(int elem : nums) up.add(elem);
        helper(p , up);
        return res;

    }
    public void helper(List<Integer> p , List<Integer> up){
        if(up.isEmpty()){
            res.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0 ; i < up.size() ; i++){
            int num = up.remove(i);
            p.add(num);
            helper(p,up);
            p.removeLast();
            up.add(i,num);
        }

    }

//https://leetcode.com/problems/permutations-ii/
    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> p = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        Arrays.sort(nums);
        for(int elem : nums) up.add(elem);
        helper2(p , up);
        return res;

    }
    public void helper2(List<Integer> p , List<Integer> up){
        if(up.isEmpty()){
            res2.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0 ; i < up.size() ; i++){
            while(i < up.size()-1 && up.get(i) == up.get(i+1))i++;
            int num = up.remove(i);
            p.add(num);
            helper2(p,up);
            p.removeLast();
            up.add(i,num);
        }

    }

}
