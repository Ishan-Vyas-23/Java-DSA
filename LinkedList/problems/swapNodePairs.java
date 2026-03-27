package LinkedList.problems;

public class swapNodePairs {

//https://leetcode.com/problems/swap-nodes-in-pairs/

    public ListNode swapPairsMy(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode res = dummy;
        while(prev != null &&curr != null ){
            ListNode nextNode = curr.next;
            prev.next = nextNode;
            res.next = curr;
            curr.next = prev;
            res = prev;
            prev = nextNode ;
            if(nextNode != null){
                curr = nextNode.next;
            }
        }
        return dummy.next;
    }

//
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevPair = dummy;

        while (prevPair.next != null && prevPair.next.next != null) {
            ListNode first = prevPair.next;           // first node of pair
            // no separate 'second' variable; use first.next inline
            // perform the swap:
            prevPair.next = first.next;              // link previous pair to second
            first.next = prevPair.next.next;         // first -> node after second
            prevPair.next.next = first;              // second -> first
            // advance to next pair
            prevPair = first;
        }

        return dummy.next;
    }

}
