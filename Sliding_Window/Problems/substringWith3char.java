package Sliding_Window.Problems;

public class substringWith3char {

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/?envType=problem-list-v2&envId=sliding-window
//similar => https://leetcode.com/problems/count-complete-subarrays-in-an-array/?envType=problem-list-v2&envId=sliding-window

    // better approach , substring ending at left
    public int numberOfSubstringsOptimal(String s) {
        int left = 0 ;
        int c = 0 ;
        int res = 0 ;
        int [] freq = new int[128];
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i);
            if(freq[ch] == 0)c++;
            freq[ch]++;
            while(c == 3){
                res += s.length() - i;
                int x = s.charAt(left);
                freq[x]--;
                if(freq[x] == 0)c--;
                left++;
            }
        }
        return res;
    }

    // exactly K = less than equal k - less than equal k-1 approach
    public int numberOfSubstrings(String s) {
        return helper(s,3) - helper(s,2);
    }
    public int helper(String s , int k){
        int left = 0 ;
        int c = 0 ;
        int res = 0 ;
        int [] freq = new int[128];
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i);
            if(freq[ch] == 0)c++;
            freq[ch]++;
            while(c > k){
                int x = s.charAt(left);
                freq[x]--;
                if(freq[x] == 0)c--;
                left++;
            }
            res += i -left+1;
        }
        return res;

    }



}
