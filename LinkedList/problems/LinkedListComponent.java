package LinkedList.problems;

import java.util.HashSet;

public class LinkedListComponent {


//https://leetcode.com/problems/linked-list-components/?envType=problem-list-v2&envId=linked-list
    public int numComponents(ListNode head, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int elem : arr){
            set.add(elem);
        }

        ListNode curr = head;
        int count = 0 ;
        while(curr!=null){
            if(set.contains(curr.val)){
                if(curr.next == null || !set.contains(curr.next.val)){
                    count++;
                }
            }
            curr=curr.next;
        }

        return count;
    }
}
