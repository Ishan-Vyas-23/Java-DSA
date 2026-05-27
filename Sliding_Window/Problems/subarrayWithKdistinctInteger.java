package Sliding_Window.Problems;

public class subarrayWithKdistinctInteger {

//https://leetcode.com/problems/subarrays-with-k-different-integers/
// exactly K = at most(k) - at most(k-1)
    public int subarraysWithKDistinct(int[] arr, int k) {
        int res= helper(arr,k) - helper(arr,k-1);
        return res;
    }
    public int helper(int [] arr , int k ){
        int l = arr.length;
        int freq[] = new int[l+1];
        int c = 0 ;
        int left = 0;
        int res = 0 ;

        for(int i = 0 ; i < l ; i++){
            if(freq[arr[i]] == 0 )c++;
            freq[arr[i]]++;
            while(c > k){
                freq[arr[left]]--;
                if(freq[arr[left]]==0)c--;
                left++;
            }
            if(c <= k){
                res += i - left + 1;
            }
        }
        return res;
    }
}
