package LinkedList.problems;

public class LLintersection {

//https://leetcode.com/problems/intersection-of-two-linked-lists/description/

    //we just traverse one list and connect its tail with other list's head , then we just check if there's any
    //cycle present in the list , if the two lists were intersecting , it would be there
    // just find that cycle starting using old logic
    // before returning just make restore the original linked lists by removing the tail to head connection

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null)return headB;
        if(headB == null)return headA;

        ListNode ptr = headA;
        while(ptr != null && ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = headB;

        ListNode slow = headA;
        ListNode fast = headA;

        while(fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next;
            if(fast == slow ){
                ListNode temp = headA ;
                while(temp != null && slow != null){
                    if(temp == slow){
                        ptr.next = null;
                        return temp;
                    }else{
                        temp = temp.next ;
                        slow = slow.next ;
                    }
                }
            }
        }
        ptr.next= null;
        return null;
    }
}
