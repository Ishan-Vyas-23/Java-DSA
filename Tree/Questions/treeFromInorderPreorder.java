package Tree.Questions;

import java.util.HashMap;
import java.util.Map;

public class treeFromInorderPreorder {

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=problem-list-v2&envId=tree
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for(int i = 0 ; i < len ; i++){
            map.put(inorder[i],i);
        }

        TreeNode root = makeTree(preorder,inorder,0,len-1,0);
        return root;
    }

    public TreeNode makeTree(int [] pre , int [] in , int start , int end,int curr){
        if (start > end) return null;

        TreeNode root = new TreeNode(pre[curr]);

        int index = map.get(pre[curr]);
        int left = index - start ;

        root.left = makeTree( pre , in , start , index-1 , curr + 1 );
        root.right = makeTree(pre , in , index+1, end, left + curr + 1 );

        return root;
    }
}
