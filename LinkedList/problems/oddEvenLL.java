package LinkedList.problems;

public class oddEvenLL {

    // O(1) extra space solution

//https://leetcode.com/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode oddHead = odd;

        ListNode even = head.next;
        ListNode evenHead = even;

        head = head.next.next;

        int i = 1;

        while (head != null) {
            if (i % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

            head = head.next;
            i++;
        }

        even.next = null;

        odd.next = evenHead;
        return oddHead;
    }
}
