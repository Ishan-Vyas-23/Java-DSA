package Sliding_Window.Problems;

public class longestOneArray {

//https://leetcode.com/problems/max-consecutive-ones-iii/
    public int longestOnes(int[] arr, int k) {
        int z = 0 ;
        int max = 0 ;
        int left = 0 ;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]==0){
                z++;
                while(z > k ){
                    if(arr[left]==0)z--;
                    left++;
                }
            }
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
