package StacksAndQueues;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
//        Stack<Integer> stack = new Stack<>();
//        stack.push(8);
//        System.out.println(stack.pop());

//        CustomStack stack = new DynamicStack();
//        int n = 5;
//        for (int i = 1; i <= n; i++) {
//            stack.push(i);
//        }
//        for (int i = 1; i <= n ; i++) {
//            System.out.println(stack.pop());
//        }

//        CustomQueue q = new CustomQueue(5);
//        q.insert(3);
//        q.insert(4);
//        q.insert(5);
//        q.insert(6);
//        q.insert(7);
//        q.display();
//        System.out.println(q.remove());
//        q.display();

//        CustomQueue q = new DynamicQueue(1);
//       int n= 10;
//        for (int i = 1; i <= n ; i++) {
//            q.insert(i);
//        }
//        q.display();
//        q.remove();


//        CircularQueue Q = new CircularQueue(5);
//        Q.insert(5);
//        Q.display();
//        Q.remove();
//        Q.display();
//        Q.insert(121);
//        Q.display();


        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        q.add(1);
        System.out.println(q.remove());
    }
}
