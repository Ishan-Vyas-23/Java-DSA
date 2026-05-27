package Sliding_Window.Problems;

public class binarySubarraySum {

//https://leetcode.com/problems/binary-subarrays-with-sum/
    public int numSubarraysWithSum(int[] arr, int k) {
        return helper(arr,k) - helper(arr,k-1);
    }
    public int helper(int [] arr , int k){
        if(k < 0)return 0;
        int c = 0;
        int left = 0;
        int sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            while(sum > k){
                sum -= arr[left];
                left++;
            }
            c += i -left+1;
        }
        return c;
    }
}
