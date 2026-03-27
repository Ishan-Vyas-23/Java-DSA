package LinkedList.problems;

public class RotateList {

//https://leetcode.com/problems/rotate-list/
    int getSize(ListNode node){
        int size = 0 ;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }
    ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int size = getSize(head);
        k = k%size;
        k = size - k;
        if(k == 0 )return head;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;

        ListNode prev = tail;
        for(int i = 0 ;i < k ;i++){
            prev = head;
            head = head.next;
        }
        prev.next = null;
        return head;
    }
}
