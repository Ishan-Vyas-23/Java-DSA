package Sliding_Window.Problems;
import java.util.*;

public class completeSubArray {

//https://leetcode.com/problems/count-complete-subarrays-in-an-array/?envType=problem-list-v2&envId=sliding-window
// similar
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/?envType=problem-list-v2&envId=sliding-window

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinctSet = new HashSet<>();

        for (int x : nums) {
            distinctSet.add(x);
        }

        int totalDistinct = distinctSet.size();

        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int distinctInWindow = 0;
        int ans = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {

            freq.put(nums[right],
                    freq.getOrDefault(nums[right], 0) + 1);

            if (freq.get(nums[right]) == 1) {
                distinctInWindow++;
            }

            while (distinctInWindow == totalDistinct) {

                ans += n - right;

                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0) {
                    distinctInWindow--;
                }

                left++;
            }
        }

        return ans;
    }
}
