package LinkedList.problems;

import LinkedList.NodeRandom;

import java.util.HashMap;
import java.util.Set;


public class copyListRandomNode {


//https://leetcode.com/problems/copy-list-with-random-pointer/

    // O(N) time and O(N) space with HashMap approach
    public NodeRandom copyRandomList(NodeRandom head) {
        HashMap<NodeRandom,NodeRandom> map = new HashMap<>();
        NodeRandom temp = head;
        NodeRandom res = null;
        while(temp!=null){
            NodeRandom newNode = new NodeRandom(temp.val);
            if(map.isEmpty()){
                res = newNode;
            }
            map.put(temp,newNode);
            temp=temp.next;
        }

        Set<NodeRandom> set = map.keySet();
        for(NodeRandom node : set){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return res;
    }

    // O(N) time O(1) space optimal solution :
    
}
