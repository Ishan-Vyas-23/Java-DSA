package LinkedList.problems;

public class PartitionLinkedList {

//https://leetcode.com/problems/partition-list/
    public ListNode partition(ListNode head, int x) {
        ListNode f = null;
        ListNode fHead= null;

        ListNode s = null;
        ListNode sHead= null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = null;
            int elem=  curr.val;
            if(elem < x){
                if(fHead == null){
                    f = curr;
                    fHead = curr;
                }else{
                    f.next = curr;
                    f=f.next;
                }
            }
            else{
                if(sHead == null){
                    s = curr;
                    sHead = curr;
                }else{
                    s.next = curr;
                    s=s.next;
                }
            }
            curr = nextNode;
        }
        if(f!=null){
            dummy.next = fHead;
            f.next = sHead;
        }else{
            dummy.next = sHead;
        }

        return dummy.next;
    }
}
