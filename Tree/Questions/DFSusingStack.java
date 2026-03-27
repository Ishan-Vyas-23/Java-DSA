package Tree.Questions;

import java.util.Stack;

public class DFSusingStack {

    public void dfsWithStack(TreeNode root ){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
}
