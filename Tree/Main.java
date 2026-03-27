package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(sc);
//        tree.prettyDisplay();
        ArrayList<Integer> list = new ArrayList<>();
        list.removeLast();
        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        tree.display();
        System.out.println(tree.height());
    }
}
