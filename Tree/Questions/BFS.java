package Tree.Questions;

import java.util.*;


public class BFS {

//store levels
//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                temp.add(curr.value);
                if(curr.left != null )q.offer(curr.left);
                if(curr.right != null )q.offer(curr.right);
            }
            list.add(temp);
        }

        return list;
    }

//average of levels
//https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0 ;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                sum = sum + curr.value;
                if(curr.left != null )q.offer(curr.left);
                if(curr.right != null )q.offer(curr.right);
            }
            list.add(sum/size);
        }
        return list;
    }

//zigzag Tree traversal BFS
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//using dequeue

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                if(!flag){
                    TreeNode curr = q.pollFirst();
                    temp.add(curr.value);
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right);
                } else {
                    TreeNode curr = q.pollLast();
                    temp.add(curr.value);
                    if(curr.right != null) q.addFirst(curr.right);
                    if(curr.left != null) q.addFirst(curr.left);
                }
            }

            list.add(temp);
            flag = !flag;
        }

        return list;
    }

//https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root.left == null && root.right == null) return true;

        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            int size = q.size() ;
            for(int i = 0 ; i < size ; i++){
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if(left == null && right == null){
                    continue;
                }
                if(left == null || right == null){
                    return false;
                }
                if(left.value != right.value){
                    return false;
                }
                q.offer(left.left);
                q.offer(right.right);
                q.offer(left.right);
                q.offer(right.left);
            }
        }
        return true;
    }

//

}