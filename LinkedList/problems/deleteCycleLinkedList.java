package LinkedList.problems;

public class deleteCycleLinkedList {

//https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?page=1&category=Linked%20List&difficulty=Medium&sortBy=submissions
    public static void removeLoop(Node head) {
        if(head == null || head.next == null){
            return ;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                Node temp = head;

                while(slow != null && temp!= null){
                    if(temp == slow){
                        prev.next = null;
                        return;
                    }else{
                        prev = slow;
                        slow =slow.next;
                        temp=temp.next;
                    }

                }

            }

        }
    }
}
