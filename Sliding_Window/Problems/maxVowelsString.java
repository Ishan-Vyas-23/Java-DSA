package Sliding_Window.Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class maxVowelsString {

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    public int maxVowels(String s, int k) {
        int maxlen = 0 ;

//        HashSet<Character> set =new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');

        //instead of above 6 lines => line 21
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        for(int i =  0  ; i < k ; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                maxlen++;
            }
        }
        int count = maxlen ;
        for(int i = k  ; i < s.length() ; i++){
            if(set.contains(s.charAt(i-k))){
                count--;
            }
            if(set.contains(s.charAt(i))){
                count++;
            }
            maxlen = Math.max(count,maxlen);
        }

        return maxlen;
    }
}
