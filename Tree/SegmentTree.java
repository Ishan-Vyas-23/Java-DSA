package Tree;

public class SegmentTree {

    public static void main(String[] args) {
        int [] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(1,6));
    }

    // the node contains the interval , the sum or data , left and right pointer
    private static class Node{
        int data ;
        int startInterval;
        int endInterval;
        Node left ;
        Node right ;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root ;

    public SegmentTree(int [] arr) {
        // create tree using this array
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int [] arr , int start , int end){
        if(start ==  end){
            // leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node node = new Node(start,end);
        int mid = start + (end - start)/2;
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        // the sum at the current node if what you are getting from left + from right
        node.data = node.left.data + node.right.data;
        return node;
    }

    //query
    public int query(int qsi , int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node , int qsi , int qei){
        // all items in
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }
        //completely outside
        else if (node.endInterval < qsi || node.startInterval > qei) {
            return 0 ;
        }else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }

    //update value
    public void update(int index , int val){
        this.root.data = update(this.root,index ,val);
    }
    private int update(Node node,int index , int val){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = val;
                return node.data;
            }else{
                int leftAns = update(node.left,index , val);
                int rightAns = update(node.right,index,val);
                node.data = leftAns+rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str =  "" ;

        if(node.left != null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + "=>" ;
        }else{
            str = str +  "no left child" ;
        }

        // for current
        str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + "=>" ;
        if(node.right != null){
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data + "=>" ;
        }else{
            str = str +  "no right child" ;
        }

        System.out.println(str);
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }
}
