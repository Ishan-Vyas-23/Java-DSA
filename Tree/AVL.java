package Tree;

public class AVL {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVL() {

    }

    public int height(){
        return height(root);
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // this rotate(node) will return node only until the tree gets unbalanced
        return rotate(node);
    }

    //https://www.geeksforgeeks.org/dsa/deletion-in-an-avl-tree/
    private Node delete(Node root, int key) {
        // Step 1: Standard BST deletion
        if (root == null) return null;

        if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // Node found — 3 cases
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Both children exist — find inorder successor (min of right subtree)
                Node successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.value = successor.value;
                root.right = delete(root.right, successor.value);
            }
        }

        // Step 2: Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Step 3: Rebalance — reuse your existing rotate() method
        return rotate(root);
    }

    private Node rotate(Node node) {

        // 4 cases =>> left left , left right , right right , right left

        //left heavy => left heavy has two cases
        if (height(node.left) - height(node.right) > 1) {
            //left left
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            // left right
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        //right heavy
        if (height(node.left) - height(node.right) < -1) {
            // right right
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            //right left
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // if tree is balanced only it will return the node only
        return node;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p ;
        p.left = t ;

        //update heights
        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.left),height(c.right)) + 1;

        return c;
    }

    public Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p ;
        p.right = t ;

        //update heights
        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.left),height(c.right)) + 1;

        return c;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

}