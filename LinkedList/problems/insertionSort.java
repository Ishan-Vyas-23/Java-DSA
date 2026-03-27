package LinkedList.problems;

public class insertionSort {

    public ListNode sortList(ListNode node) {
        if(node == null || node.next == null){
            return node ;
        }
        ListNode first = node;
        ListNode second = node.next;

        while(second != null){
            ListNode min = first;
            ListNode temp = second;
            while(temp != null){
                if(min.val > temp.val){
                    min = temp;
                }
                temp = temp.next;
            }
            int elem = first.val;
            first.val = min.val;
            min.val = elem;
            first = first.next;
            second = second.next;
        }
        return node;
    }
}
