package Sliding_Window.Problems;

public class characterReplacement {

//https://leetcode.com/problems/longest-repeating-character-replacement/
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int[] freq = new int[26];
        int max = 0 ;
        int left = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int elem = ch-'A';
            freq[elem]++;
            maxFreq = Math.max(freq[elem],maxFreq);
            int window = i - left + 1 ;
            if(window - maxFreq <= k ){
                max = Math.max(max,window);
            }else{
                while(i - left + 1 - maxFreq> k ){
                    freq[s.charAt(left)-'A']--;
                    left++;
                }
            }
        }
        return max;
    }
}
