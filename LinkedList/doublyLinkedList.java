package LinkedList;

public class doublyLinkedList {

   private Node head;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node ;
        }
        head = node ;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            insertFirst(val);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
    }

    public void insert(int val , int index){
        if(index == 0 || head == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head ;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        if(temp == null){
            insertFirst(val);
            return;
        }
        if(temp.next == null){
            insertLast(val);
            return;
        }
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node ;
        temp.next = node;
    }



    public void display(){
        Node node = head ;
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.next ;
        }
        System.out.println("END");
    }





    private class Node {
        int val ;
        Node next ;
        Node prev ;

        public Node(int val){
            this.val = val ;
        }
        public Node(int val , Node next , Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
