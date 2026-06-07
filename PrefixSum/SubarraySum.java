package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

//https://leetcode.com/problems/subarray-sum-equals-k/description/
// similar problem => https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

    /*
    Idea:
    Instead of generating all sub-arrays, use Prefix Sum + HashMap.

    Let 'sum' be the prefix sum from index 0 to i.

    For a sub-array ending at index i to have sum = k:

        currentPrefix - previousPrefix = k

    Rearranging:

        previousPrefix = currentPrefix - k

    So at every index, we ask:
    "How many previous prefix sums equal (sum - k)?"

    If such prefix sums exist, each one forms a valid sub-array
    ending at the current index with sum exactly k.

    HashMap stores:
        prefixSum -> frequency

    map.put(0,1) represents the empty prefix before the array starts.
    This allows us to count sub-arrays that begin from index 0.

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public int subarraySum(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0 ;
        int sum = 0 ;
        map.put(0,1);
        for(int i = 0 ; i < arr.length ;i++){
            sum += arr[i];
            res += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
