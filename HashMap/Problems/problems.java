package HashMap.Problems;

import java.util.*;

public class problems {

//https://leetcode.com/problems/first-unique-character-in-a-string/description/
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

//https://leetcode.com/problems/valid-anagram/
    //anagram and nagaram are anagrams

    // just count frequencies of character and then decrease them while iterating through other string
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // decrement
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            if (count == null || count == 0) return false;   // t has extra char
            if (count == 1) map.remove(c);                  // remove key from map that has 0 value
            else map.put(c, count - 1);
        }

        // all counts matched => map should be empty
        return map.isEmpty();
    }

//https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String , ArrayList<String> > map = new HashMap<>();
        for(String s : strs){
            String sorted = getSortedString(s);
            if(!map.containsKey(sorted)){
                map.put(sorted , new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        Set<String> keys = map.keySet();
        for(String key : keys ){
            list.add(map.get(key));
        }
        return list;
    }
    public String getSortedString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted ;
    }

//https://leetcode.com/problems/top-k-frequent-elements/

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num :  nums){
            map.put(num,map.getOrDefault(num , 0 ) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>( (a,b) -> Integer.compare(map.get(a),map.get(b)) );
        Set<Integer>  keys = map.keySet();
        for(int key : keys ){
            q.offer(key);
            if(q.size() > k){
                q.poll();
            }
        }
        int [] arr = new int[k];
        int j = 0 ;
        for(int i = 0 ; i < k ; i++){
            arr[j] = q.poll();
            j++;
        }
        return arr;
    }

//

}
