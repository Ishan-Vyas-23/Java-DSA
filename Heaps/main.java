package Heaps;

import java.util.*;

public class main {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> a-b );
        minHeap.offer(3);
        minHeap.offer(1);
        minHeap.offer(7);
        minHeap.offer(111);
        minHeap.offer(93);
        minHeap.offer(-2);
        System.out.println(minHeap.peek());
        System.out.println(minHeap);
        System.out.println(minHeap.poll());
        System.out.println(minHeap);
        int dig = 12234;
        int n = (int)(Math.log10(dig)) +1;
        System.out.println("digits : " + n);

        int [] arr = {5,3,5,5,5};
        System.out.println(minimumDistance(arr));
    }

    public static int minimumDistance(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            List<Integer> list = map.getOrDefault(nums[i] , new ArrayList<>());
            list.add(i);
            map.put(nums[i] , list);
        }
        Set<Integer> set = map.keySet();
        for(int key : set){
            if(map.get(key).size() >= 3){
                q.offer(dist(map.get(key)));
            }
        }
        if(!q.isEmpty()){
            return q.peek();
        }
        return -1;
    }
    public static int dist(List<Integer> list){
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 2));
        }
        return min;
    }
}
