package Sliding_Window.Problems;

public class substringWithKrepeatingCharacters {

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/?envType=problem-list-v2&envId=sliding-window
    // easier version with just k = 2 , lc 159
    public int longestSubstring(String s, int k) {

        int max = 0 ;

        for(int j = 1 ; j <= 26 ; j++){
            int left = 0 ;
            int freq[] = new int[26];
            int c = 0 ;
            int p = 0 ;

            for(int i = 0 ; i < s.length() ; i++){
                char ch = s.charAt(i);
                if(freq[ch-'a'] == 0 )c++;
                freq[ch-'a']++;
                if(freq[ch-'a'] == k)p++;
                while(c > j){
                    char temp = s.charAt(left);
                    if(freq[temp-'a'] == k)p--;
                    freq[temp-'a']--;
                    if(freq[temp-'a'] == 0)c--;
                    left++;
                }
                if(c == j && c == p){
                    max = Math.max(max,i-left+1);
                }
            }
        }

        return max;
    }
}
