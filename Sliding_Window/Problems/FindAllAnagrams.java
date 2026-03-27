package Sliding_Window.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//also similar problem just return boolean instead list keeping
//https://leetcode.com/problems/permutation-in-string/

// it's the application of an approach for storing frequencies of chars in a string using a single int[26] array
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();

        if(plen > slen)return list;

        // these arr1 and arr2 are the frequency counter arrays
        // arr1 => counts the frequencies of characters in string s i.e. the bigger one
        // arr2 => counts the frequencies of characters in string p i.e. the smaller one
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // what we do is we first create a window of size plen and puts frequencies of chars in the arrays
        // now check if the arrays are equal => add index 0 if yes
        for(int i = 0 ; i < plen ; i++){
            arr1[s.charAt(i) - 'a' ]++ ;
            arr2[p.charAt(i) - 'a']++ ;
        }

        if(Arrays.equals(arr1,arr2)){
            list.add(0);
        }

        // now slide the window such that remove the frequency of the leaving element and add the frequency of entering elem

        for(int i = plen ; i < slen ; i++){
            arr1[s.charAt(i) - 'a' ]++;
            arr1[s.charAt(i-plen) - 'a']--;
            // now check if the arrays are equal and update the list
            if(Arrays.equals(arr1,arr2)){
                list.add(i-plen+1);
            }
        }

        return list;
    }
}
