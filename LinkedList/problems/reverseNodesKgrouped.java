package LinkedList.problems;

public class reverseNodesKgrouped {

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        int numberOfRotations = size/k;
        int left =1;
        for(int i = 1 ; i<= numberOfRotations;i++){
            head = reverseBetween(head,left,left+k-1);
            left = left+k;
        }
        return head;
    }
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
    public int getSize(ListNode head){
        int size=0 ;
        while(head != null){
            size++;
            head=head.next;
        }
        return size;
    }
}
