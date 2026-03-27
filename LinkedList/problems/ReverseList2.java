package LinkedList.problems;

public class ReverseList2 {

//https://leetcode.com/problems/reverse-linked-list-ii/description/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)return head;
        if(left == right)return head;
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1 ; i <= left -1 ; i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode start = prev ;
        for(int i = 0 ; i <= right -left ; i++){
            ListNode nextnode = curr.next;
            curr.next= prev;
            prev = curr;
            curr = nextnode;
        }
        if(start == null){
            head.next = curr;
            return prev;
        }
        start.next.next = curr;
        start.next = prev;
        return head;
    }
}
