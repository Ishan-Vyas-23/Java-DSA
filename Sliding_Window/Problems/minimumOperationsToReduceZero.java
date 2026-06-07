package Sliding_Window.Problems;

public class minimumOperationsToReduceZero {

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
    public int minOperations(int[] arr, int x) {
        int left = 0 ;
        int len = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int elem : arr)sum += elem;
        int target = sum - x ;
        if(target < 0)return -1;
        sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            while(sum > target){
                sum -= arr[left];
                left++;
            }
            if(sum == target){
                len = Math.max(len,i-left+1);
            }
        }
        if(len == Integer.MIN_VALUE)return -1;
        return arr.length - len;
    }
}
