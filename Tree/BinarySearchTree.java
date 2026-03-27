package Tree;

import Tree.Questions.TreeNode;

public class BinarySearchTree {
    public class Node{
        public int value;
        public int height ;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val ;
        }

        public int getValue() {
            return value;
        }
    }
    public  Node root;

    public BinarySearchTree() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null ;
    }

    public void display(){
        display(root,"Root Node: ");
    }

    public void display(Node node , String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left,"Left child of " + node.getValue() + " : ");
        display(node.right,"Right child of " + node.getValue() + " : ");
    }

    public void insert(int value){
        root = insert(value,root);
    }

    public Node insert(int value , Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value,node.left);
        }
        else{
            node.right = insert(value,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        return node;
    }

    public Node search(Node root , int target){
        if(root == null)return root;

        if(root.value == target)return root;
        if(root.value > target){
            return search(root.left,target);
        }
        return search(root.right,target);
    }

    // delete from BST:
    // for the target node having two children:
    //      -> find node coming next to it in the in order traversal(farthest left) in the right side subtree
    //      -> replace target with successor
    //      -> now delete
    // https://www.geeksforgeeks.org/dsa/deletion-in-binary-search-tree/
    public Node deleteNode(Node root, int key) {
        if(root == null)return root;
        if(root.value == key){
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else {
                Node successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.value = successor.value;
                root.right = deleteNode(root.right, successor.value);
            }
        }
        else if(root.value > key){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    // Create BST from Sorted Array :
    public TreeNode sortedArrayToBST(int[] arr) {
        return makeTree(arr,0,arr.length-1);
    }
    public TreeNode makeTree(int [] arr ,  int start , int end){
        if(start > end)return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = makeTree(arr,start,mid-1);
        node.right = makeTree(arr,mid+1,end);
        return node;
    }

}
