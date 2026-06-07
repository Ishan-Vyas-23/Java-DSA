package Sliding_Window.Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindowMaximum {

//https://leetcode.com/problems/sliding-window-maximum/
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0 ;
        int [] res = new int[arr.length-k+1];
        int c= 0 ;

        for(int i = 0 ; i < k ; i++){
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        res[c++]=arr[q.peek()];

        for(int i = k ; i < arr.length ; i++){
            if(!q.isEmpty() && q.peekFirst() == left)
                q.removeFirst();
            left++;
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
            res[c++]=arr[q.peek()];
        }
        return res;
    }
}
