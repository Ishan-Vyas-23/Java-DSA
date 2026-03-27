package Sliding_Window.Problems;

public class maxSubArrayAverage {

//https://leetcode.com/problems/maximum-average-subarray-i/

    // also keep in mind double in java is slower than int so maybe you can use int for sum and max and then
    // cast it to double while returning
    public double findMaxAverage(int[] nums, int k) {
        double max = 0 ;
        for(int i  = 0  ; i < k ; i++){
            max =  max + nums[i];
        }
        double sum = 0 ;
        sum = max;
        for(int i  = k ; i < nums.length ; i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(sum,max);
        }
        return max/k;
    }
}
