package LinkedList.problems;

public class deleteNodesGreaterToRight {

//https://leetcode.com/problems/remove-nodes-from-linked-list/
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int max = Integer.MIN_VALUE;
        while(curr != null){
            if(curr.val < max){
                prev.next = curr.next;
                curr = prev.next;
            }else{
                prev =curr;
                max = Math.max(max,curr.val);
                curr = curr.next;
            }
        }
        head=reverseList(dummy.next);
        return head;
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode node = curr.next;
            curr.next=prev;
            prev = curr;
            curr =node;
        }
        return prev;
    }
}
