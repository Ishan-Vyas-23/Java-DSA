package Tree.Questions;

public class TreeNode {
      int value;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      public TreeNode(int val) { this.value = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.value = val;
          this.left = left;
          this.right = right;
      }
}
