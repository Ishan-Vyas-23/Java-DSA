package Heaps.problems;

import java.util.*;

public class problems {

//https://leetcode.com/problems/kth-largest-element-in-an-array/

    // the trick to remember is that we only need the k greatest elements in the array , if k = 3 ;
    // we only need 3 greatest elements and we need to return the smallest amongst these 3 elements
    // we maintain a min heap and as the number of elements in the heap cross 3 we remove the smallest element from it
    // at the end after iteration we have the 3 largest elements in increasing order from that array
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int elem : nums){
            q.offer(elem);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }

//https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> distance(b) - distance(a));
        for(int [] arr : points){
            q.offer(arr);
            if(q.size() > k){
                q.poll();
            }
        }
        int [][] res = new int[q.size()][];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = q.poll();
        }
        return res;

    }
    public int distance(int [] arr){
        int a = arr[0];
        int b = arr[1];
        int d = (a*a) + (b*b);
        return d ;
    }

//https://leetcode.com/problems/top-k-frequent-words/
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((a,b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(a) - map.get(b);

                //if both frequencies are equal we check for lexicographically larger word
            } else {
                return b.compareTo(a);
            }
        });
        Set<String> set = map.keySet();
        for(String key : set){
            q.offer(key);
            if(q.size() > k ){
                q.poll();
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i<k ;i++){
            list.add(q.poll());
        }
        Collections.reverse(list);
        return list;
    }

//https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=problem-list-v2&envId=heap-priority-queue
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character > q = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b),map.get(a)));
        Set<Character> keys = map.keySet();
        for(char key : keys){
            q.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            int freq = map.get(ch);
            for(int i = 0 ; i < freq ;i++){
                sb.append(ch);
            }

        }
        return sb.toString();
    }

//https://leetcode.com/problems/find-k-closest-elements/
    public  List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>( (a,b) -> {
            int diff = dist(b,x) - dist(a,x);

            // for similar distanced elements smaller one comes first
            if(diff == 0){
                return b-a ;
            }
            return diff ;
        } );
        for(int elem : arr){
            q.offer(elem);
            if(q.size() > k ){
                q.poll();
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll());
        }
        Collections.sort(list);
        return list;
    }
    public  int dist(int a , int x ){
        return Math.abs(a-x);
    }

// 

}

