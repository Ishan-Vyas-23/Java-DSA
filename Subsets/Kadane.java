package Subsets;

public class Kadane {

//https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int elem : nums){
            if(sum < 0 ){
                sum = 0 ;
            }
            sum += elem;
            max = Math.max(sum,max);
        }
        return max;
    }

}
