package LinkedList.problems;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class Flatten {
    public static void main(String[] args) {

        // Level 1
        Node n1 = new Node(); n1.val = 1;
        Node n2 = new Node(); n2.val = 2;
        Node n3 = new Node(); n3.val = 3;
        Node n4 = new Node(); n4.val = 4;
        Node n5 = new Node(); n5.val = 5;
        Node n6 = new Node(); n6.val = 6;

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        // Level 2
        Node n7 = new Node(); n7.val = 7;
        Node n8 = new Node(); n8.val = 8;
        Node n9 = new Node(); n9.val = 9;
        Node n10 = new Node(); n10.val = 10;

        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;

        // Level 3
        Node n11 = new Node(); n11.val = 11;
        Node n12 = new Node(); n12.val = 12;

        n11.next = n12; n12.prev = n11;

        // Attach children
        n3.child = n7;
        n8.child = n11;

        // Call flatten
        Flatten sol = new Flatten();
        Node head = sol.flatten(n1);

        // Print forward
        System.out.println("Forward traversal:");
        Node curr = head;
        Node tail = null;
        while (curr != null) {
            System.out.print(curr.val + " ");
            tail = curr;
            curr = curr.next;
        }

        // Print backward
        System.out.println("\nBackward traversal:");
        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.prev;
        }
    }

    public Node flatten(Node head) {
        if(head == null) return head;
        Node ptr = head;
        while(ptr != null){
            if(ptr.child == null){
                ptr = ptr.next;
            }else{
                Node nextNode = ptr.next;
                Node tail = ptr.child;
                tail.prev = ptr;
                ptr.next = tail;
                while(tail.next !=null){
                    tail = tail.next;
                }
                ptr.child = null;
                if(nextNode!=null){
                    nextNode.prev = tail;
                }
                tail.next = nextNode;
                ptr = ptr.next;
            }
        }
        return head;
    }

}
