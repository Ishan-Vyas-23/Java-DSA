package LinkedList;

public class CustomLinkedList {

    private Node head; // head of the List
    private Node tail; // tail of the list
    private int size; // list size

    public CustomLinkedList() {
        this.size = 0; // list initialized with size 0 on creation
    }

    //to add element at the start of the List
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head ; //as we are inserting at the start so newly added element should point to the head of the List
        head = node ; // new head of the list will be the newly created node

        if(tail == null){ // this checks if the added node is the first element of the List , if so it should be both head and tail
            tail = head;
        }
        size += 1 ; // linked list gets new element so size increment by 1
    }

    //insert at last of list
    public void insertLast(int value){
        if(tail == null){ // if no element is there in the list
            insertFirst(value);
            return;
        }
        Node node = new Node(value); //create new node
        tail.next = node; // the current tail's next should point to the newly added node at the last
        tail = node;// new node is the new tail now

        size += 1 ;
    }

    //insert anywhere
    public void insert(int value ,int index){
       if(index == 0){
           insertFirst(value);
           return;
       }
       if(index == size){
           insertLast(value);
           return;
       }
       Node temp = head; //create a pointer which starts which head
        for (int i = 1; i < index; i++) { // this loop stops at the index before the index which we are required to insert at
            temp = temp.next; //just re-initializing the pointer till it reaches before the required index
        }
        //after the loop has executed the temp now is the node at previous index of the required index

        Node node = new Node(value , temp.next); // new node should have its next attribute set as the next node of the previous next ,temp.next is the node which was previously at the given index which now shifts forward by 1 and the new node gets replaced at that index
        temp.next = node;//finally the temp should now point to the new element added after it i.e, node
        size += 1;
    }

    //delete first
    public int deleteFirst(){
        int val = head.value;
        head = head.next ;
        if(head==null){ //if only one element present in list and it gets deleteda
            tail = null;
        }
        size--;
        return val;
    }

    //delete last
    public int deleteLast(){
        if(size <= 1){
            deleteFirst();
        }
        Node secondLast = getNode(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    //delete any
    public int delete(int index){
        if(index == 0){
            deleteFirst();
            return head.value;
        }
        if(index == size - 1){
            deleteLast();
            return tail.value;
        }
        Node prev = getNode(index-1);
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
        size--;
        return curr.value;
    }

    public int sum(){
        int sum = 0 ;
        Node temp = head;
        while(temp != null){
            sum += temp.value;
            temp = temp.next;
        }
        return sum;
    }

    public void replace(int index , int val){
        if(index >= size || index <0 ){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = getNode(index);
        temp.value = val;
    }

    //get a reference pointer of any element of Linked List
    public Node getNode(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //get a reference pointer by value
    public Node find(int val){
        Node node = head;
        for (int i = 0; i < size; i++) {
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void addArray(int [] arr , int index){
        if(index >= size || index < 0){
            System.out.println("Inavlid Index ");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i],i+index);
        }
    }

    //to print elements of List
    public void display(){
        Node temp = head ; // setting the pointer
        while (temp != null){ // condition to stop printing when the pointer reaches end of List
            System.out.print(temp.value + " -> ");
            temp = temp.next ; // re-assign pointer to the next node
        }
        System.out.println("END");
    }

    //insert using recursion
    private void insertRec(int val , int index , Node node){
        if(index == 0){
            Node newNode = new Node(val , head);
            head = newNode;
            size++;
            return;
        }
        if(index == 1){
            Node newNode = new Node(val , node.next );
            node.next = newNode;
            size++;
            return;
        }
        insertRec(val , index-1 , node.next);
    }

    public void insertRec(int val , int index){
        insertRec(val , index , head);
    }

    private class Node {
        private int value;
        private Node next ;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
