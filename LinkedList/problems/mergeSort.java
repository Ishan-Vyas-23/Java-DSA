package LinkedList.problems;

public class mergeSort {
    public ListNode sortList(ListNode node) {
        if(node == null || node.next == null){
            return node ;
        }
        ListNode mid = middleNode(node);
        ListNode left = sortList(node);
        ListNode right = sortList(mid);

        return mergeTwoLists(left  , right);
    }
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode f = new ListNode(-1);
        ListNode head = f ;
        if(p1 == null) return p2;
        if(p2 == null) return p1;

        while(p1 != null && p2 != null){
            if(p1.val >= p2.val){
                f.next = p2 ;
                p2 = p2.next;
            }else{
                f.next = p1;
                p1 = p1.next;
            }
            f = f.next ;
        }
        while(p1 != null){
            f.next = p1 ;
            p1 = p1.next ;
            f = f.next ;
        }
        while(p2 != null){
            f.next = p2 ;
            p2 = p2.next ;
            f = f.next;
        }
        return head.next;
    }
    static ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null; // as slow if the middle node if we do not disconnect it
        // from other half of the list it will cause infinite recursion

        return slow;
    }
}