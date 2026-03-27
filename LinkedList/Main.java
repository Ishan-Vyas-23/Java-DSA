package LinkedList;


public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
//        doublyLinkedList list = new doublyLinkedList();
        int [] array = {3,5,9,8,23,0};
        int [] array2 = {1,2,4};
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.display();
        list.insertRec(81,0);
        list.display();
    }
}
