package Sliding_Window.Problems;

public class minimumWindowSubsrting {

//https://leetcode.com/problems/minimum-window-substring/
    // similar
    // LC 438 (Find All Anagrams)
    // LC 567 (Permutation in String)
    // LC 424 (Longest Repeating Character Replacement)
    // LC 992 (Subarrays with K Different Integers)
    // LC 76 variants in interviews

    public String minWindow(String s, String t) {
        int left = 0 ;
        String res = "";
        int c = 0;
        int m = s.length();
        int n = t.length();
        int len = Integer.MAX_VALUE;
        if(n > m)return "";
        int []tfreq = new int[128];
        int []sfreq = new int[128];
        int a = 0 ;
        int b = 0;

        for(int i = 0 ; i < n ; i++ ){
            tfreq[t.charAt(i)]++;
        }
        for(int i = 0 ; i < m ; i++){
            char ch = s.charAt(i);
            sfreq[ch]++;
            if(tfreq[ch] != 0 && sfreq[ch] <= tfreq[ch])c++;
            while(c==n){
                if(len > i-left+1){
                    a = left ;
                    b = i + 1;
                    len = i - left +  1;
                }
                char leftChar = s.charAt(left);
                if(tfreq[leftChar] != 0 && sfreq[leftChar] <= tfreq[leftChar])c--;
                sfreq[leftChar]--;
                left++;
            }
        }
        if(len != Integer.MAX_VALUE)res = s.substring(a,b);
        return res;
    }
}
