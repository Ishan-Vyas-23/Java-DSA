package leetcode;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
    public static int[] twoSum(int[] arr, int target) {
        int left = 0 ;
        int right  = arr.length - 1 ;
        int [] nums = new int [2];

        while(right > left){
            int sum = arr[left] + arr[right];
            if( sum == target){
                nums[0] = left+1;
                nums[1] = right + 1;
                return nums;
            }else{
                if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return nums;
    }
}
