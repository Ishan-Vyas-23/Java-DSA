package Tree;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }

    private static class Node{
         private int value ;
         Node left;
         Node right ;

         public Node(int value) {
             this.value = value;
         }
    }

    private Node root;

    //insert element
    public void populate(Scanner scanner){
        System.out.println("Enter the root node value ; ");
        int value = scanner.nextInt() ;
        root = new Node(value);
        populate(scanner,root);
    }
    private void populate(Scanner scanner , Node node){

        System.out.println("Do you want to enter the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter value of left of " + node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter value of right of " + node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void display(Node node , String indent){
        if(node == null){
            return ;
        }
        System.out.println(indent + node.value);
        display(node.left , indent + '\t');
        display(node.right , indent + '\t');
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
    // 1 => Pre-Order => Node -> Left -> Right
    // used for evaluating mathematical exps or making a copy
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2 => In-Order => Left -> Node -> Right
    // go to the extreme left till node becomes null and then print it
    // return back print the node and then go for the right
    // for BST it will traverse the elements in a sorted manner
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    //3 => Post-Order => Left -> Right -> Node
    // reach the extreme left print it , print the right child
    // print the node
    // used when you want to delete from a BT
    // in deletion take care of child nodes first and then delete the node
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


    // height of binary tree
    public static int height(Node root) {
        if (root == null) return 0; // empty tree has height
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // check if tree is balanced
    public boolean isBalanced(Node root) {
        if(root == null)return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return (Math.abs(leftH - rightH ) < 2) && ( isBalanced(root.left) && isBalanced(root.right) );
    }

    // number of nodes in binary tree
    public int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
