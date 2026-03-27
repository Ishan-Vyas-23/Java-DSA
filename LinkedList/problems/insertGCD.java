package LinkedList.problems;

public class insertGCD {

//https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode node = head;
        while(node != null && node.next != null){
            int elem = findGCD(node.val,node.next.val);
            ListNode newNode = new ListNode(elem);
            ListNode nextNode = node.next;
            node.next = newNode;
            newNode.next = nextNode;
            node = nextNode;
        }
        return head;
    }

    public int findGCD(int num1 , int num2){

        if(num2 > num1){
            int temp = num1;
            num1=num2;
            num2=temp;
        }
        while(num1 % num2 != 0){
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;
        }
        return num2;
    }

}
