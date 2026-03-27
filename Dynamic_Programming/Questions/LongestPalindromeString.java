package Dynamic_Programming.Questions;

public class LongestPalindromeString {

    public String longestPalindrome(String s) {
        String t ="";
        int maxlen = 0 ;
        int n  = s.length();
        for(int i = 0 ; i  < n ; i++){

            // for odd string
            int l  = i ;
            int r  = i ;
            while( l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxlen){
                    maxlen = r-l+1;
                    t = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            // for even string
            l  = i ;
            r  = i+1 ;
            while( l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxlen){
                    maxlen = r-l+1;
                    t = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }

        return t;
    }

}
