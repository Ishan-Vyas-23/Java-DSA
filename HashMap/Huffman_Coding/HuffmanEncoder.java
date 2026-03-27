package HashMap.Huffman_Coding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://claude.ai/share/adf2bb8c-43af-4de2-a574-933a76c44611

//         HUFFMAN CODING
//        │
//        ├── 1. FREQUENCY ANALYSIS
//        │   └── Count how often each character appears in the input
//        │
//        ├── 2. BUILD MIN-HEAP (Priority Queue)
//        │   └── Each character becomes a Node, sorted by frequency (lowest = highest priority)
//        │
//        ├── 3. BUILD HUFFMAN TREE (Greedy Step)
//        │   └── Repeatedly merge the 2 lowest-frequency nodes into a parent node
//        │   └── Repeat until only 1 node (the root) remains
//        │
//        ├── 4. GENERATE CODES (Tree Traversal)
//        │   └── Traverse tree: going LEFT appends '0', going RIGHT appends '1'
//        │       └── At each LEAF node → that character's code is finalized
//        │
//        └── 5. ENCODE / DECODE
//           ├── Encode: replace each character with its binary code string
//           └── Decode: walk through coded string, match prefixes back to characters

public class HuffmanEncoder {
    HashMap<Character,String> encoder ;
    HashMap<String,Character> decoder ;

    private class Node implements Comparable<Node>{
        Character data;
        int cost; //freq
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right=null;
        }

        // +ve means our object is bigger , -ve means other object is bigger
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanEncoder(String feeder)throws Exception{
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(char ch : feeder.toCharArray()){
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);

        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Map.Entry<Character,Integer>> entrySet = fmap.entrySet();

        for(Map.Entry<Character,Integer> enrty : entrySet){
            Node node = new Node(enrty.getKey(),enrty.getValue());
            minHeap.add(node);
        }

        while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node sec = minHeap.remove();

            Node newNode = new Node('\0', first.cost+sec.cost);
            newNode.left = first;
            newNode.right =sec;

            minHeap.add(newNode);
        }

        Node ft = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderAndDecoder(ft,"");
    }

    public void initEncoderAndDecoder(Node node , String output){
        if(node == null)return;

        if(node.left == null && node.right == null){
            this.encoder.put(node.data,output);
            this.decoder.put(output,node.data);
        }
        initEncoderAndDecoder(node.left,output+'0');
        initEncoderAndDecoder(node.right,output+'1');
    }

    public String encode(String src){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < src.length(); i++) {
            sb.append(this.encoder.get(src.charAt(i)));
        }
        return new String(sb);
    }

    public String decode(String codedStr){
        String key = "";
        String ans = "" ;
        for (int i = 0; i < codedStr.length(); i++) {
            key = key + codedStr.charAt(i);
            if(this.decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key ="";
            }
        }
        return ans;
    }

}
