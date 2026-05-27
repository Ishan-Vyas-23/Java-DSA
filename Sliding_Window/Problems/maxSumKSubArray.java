package Sliding_Window.Problems;

public class maxSumKSubArray {

//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        int left = 0 ;

        for(int i = 0 ; i < arr.length ; i++ ){
            sum += arr[i];
            if(i-left+1 >= k){
                max = Math.max(max,sum);
                sum -= arr[left++];
            }
        }
        return max;
    }
}
