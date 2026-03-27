package LinkedList.problems;

public class deleteDuplicatesLL2 {


//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        while(curr != null){
            if(prev.val == curr.val){
                while(curr != null && prev.val == curr.val){
                    curr = curr.next;
                }
                prev = curr;
            }else{
                dummy.next = prev ;
                dummy = dummy.next;
                prev = prev.next;
            }
            if(curr != null)curr = curr.next;
        }
        if(prev != null){
            dummy.next = prev;
            dummy = dummy.next;
        }
        dummy.next = null;
        return res.next;
    }

}
