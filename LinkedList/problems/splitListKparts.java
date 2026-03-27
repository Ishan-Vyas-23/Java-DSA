package LinkedList.problems;

public class splitListKparts {
    
//https://leetcode.com/problems/split-linked-list-in-parts/description/
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = getSize(head);
        int minNodes = size/k;
        int extraNodes = size - (k*minNodes);
        ListNode start = head;
        for(int i = 0; i<k ;i++){
            ListNode temp = start;
            int l = minNodes;
            if(extraNodes > 0){
                l++;
                extraNodes--;
            }
            for(int j = 0 ; j< l-1 ; j++ ){
                start = start.next;
            }
            if(start == null)break;
            ListNode nextStart = start.next;
            start.next = null;
            start = nextStart;
            res[i] = temp;
        }

        return res;
    }
    public int getSize(ListNode node){
        int size = 0 ;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }
}
