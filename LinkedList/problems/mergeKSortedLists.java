package LinkedList.problems;

import java.util.PriorityQueue;

public class mergeKSortedLists {

    // we don't need to store every node of each linkedList in the heap , we just store the heads of each LL ,
    // then we just pop the minimum and then offer its next node in the queue

//https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=problem-list-v2&envId=linked-list
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node : lists){
            if(node == null)continue;
            q.offer(node);
        }
        ListNode head = q.poll();
        ListNode ptr = head;
        if(head != null && head.next != null)q.offer(head.next);
        while(!q.isEmpty()){
            ListNode node = q.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        if (ptr != null){
            ptr.next = null;
        }
        return head;
    }
}
