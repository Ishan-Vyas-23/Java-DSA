package Tree.Questions;

import LinkedList.problems.ListNode;

import java.util.*;

public class DFS {

//https://leetcode.com/problems/diameter-of-binary-tree/
// here we work in the manner such that we find height for left , we find height for right and then we work on the node
// so this traversal is dfs
    int diameter = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter -1 ;
    }
    public int height(TreeNode node){
        if(node == null) return  0 ;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter ,(left+right+1));

        return 1 + Math.max(left,right);
    }

//https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left=node.right;
        node.right=temp;
    }

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    // Solving with Queue
    public void flatten(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        treeToQueue(root, q);

        TreeNode curr = q.poll();
        while (!q.isEmpty()) {
            TreeNode next = q.poll();
            curr.left = null;
            curr.right = next;
            curr = next;
        }

    }
    private void treeToQueue(TreeNode node, Queue<TreeNode> q) {
        if (node == null) return;
        q.offer(node);
        treeToQueue(node.left, q);
        treeToQueue(node.right, q);
    }

    //the optimal solution with O(1) space complexity
    public void flattenInPlace(TreeNode root) {
        if(root == null) return;

        TreeNode curr = root ;
        while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = curr.right ;
                curr.right = curr.left ;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

//https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ( ( min!= null && node.value <= min) || ( max!= null && node.value >= max)) return false;
        return helper(node.left, min, node.value) && helper(node.right, node.value, max);
    }

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

    //if we found any one of the node there's no point in searching below as
    // even if we found the other below the first one is going to be the answer
    // so as we found just return and start searching the other side
    // if we get null from any one side that means the answer is still in the upper tree somewhere so return non null node
    // if we get a node from both side that means that node is the ancestor to both nodes

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return root;

        if(root.value == p.value || root.value == q.value){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right ;
    }

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

    //optimal approach only
    //  also solved with brute force O(n2) way with arraylist , string and string concats
    int res ;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return res;
    }
    public void helper(TreeNode root , int sum ){
        if(root == null)return;
        if(root.left == null && root.right == null){
            res = res + ((sum*10) + root.value);
        }
        helper(root.left, (sum*10) + root.value);
        helper(root.right, (sum*10) + root.value);
    }

    //you are given a tree and an array ,
    // the array contains some numbers lets call them path ,
    // now check if this path is present in the tree
    public static boolean isPathPresentInTree(TreeNode root , int [] arr){
        return isPathPresentInTree(root , arr , 0);
    }
    private static boolean isPathPresentInTree(TreeNode root , int [] arr , int index){
        if(root == null)return false;
        if( index >= arr.length || root.value != arr[index]){
            return false;
        }
        if(root.left == null && root.right == null){
            return arr.length -1  == index ;
        }
        return isPathPresentInTree(root.left , arr,index+1) || isPathPresentInTree(root.right,arr,index+1);
    }

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    // this basically has two ways either we split ways from a node so the path becomes the two ways and the node
    // or we take one of the branches and return it to above node
    // we check sum for every node which means the sum including that node , its left and its right
    // we compare this sum to global max
    // we return the maximum from left and right so that the above node gets the maximum path route
    int max = 0 ;
    public int maxPathSum(TreeNode root) {
        max = root.value;
        helper(root);
        return max ;
    }
    public int helper(TreeNode root){
        if(root == null)return 0 ;
        int left = Math.max(0,helper(root.left));
        int right  = Math.max(0,helper(root.right));
        max = Math.max(max , root.value + left + right);
        return root.value + Math.max(left, right);

    }

//https://leetcode.com/problems/path-sum-ii/
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return resList;
        helperPathSum(root,targetSum);
        return resList;
    }
    List<Integer> list = new ArrayList<>();
    public void helperPathSum(TreeNode root , int targetSum){
        if(root == null) return;
        list.add(root.value);
        if(root.left == null && root.right == null){
            if( (targetSum - root.value) == 0 ){
                resList.add(new ArrayList<>(list));
            }
        }
        helperPathSum(root.left,targetSum - root.value);
        helperPathSum(root.right,targetSum - root.value);
        list.remove(list.size() - 1); // backtracking
    }

//sorted List to BST , not the optimal approach for linked list
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null )return null;
        if(head.next == null){
            return new TreeNode(head.val);
        }
        int size = getSize(head);
        int [] arr = new int[size];
        ListNode ptr = head;
        for(int i = 0 ; i< size ; i++ ){
            arr[i] = ptr.val;
            ptr=ptr.next;
        }
        return buildTree(arr,0,size-1);
    }
    public TreeNode buildTree( int [] arr ,int start , int end){
        if(start > end)return null;
        int mid = (start + end )/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildTree(arr,start,mid-1);
        root.right = buildTree(arr,mid+1,end);
        return root;
    }
    public int getSize(ListNode node){
        int size = 0 ;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }

//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
    // tree boundary traversal =>  first add left side nodes , then leaves , then right side
    // just remember in right side nodes you have to add them in reverse order
    ArrayList<Integer> listBoundary = new ArrayList<>();
    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        if (root == null) return listBoundary;
        listBoundary.add(root.value);
        printLeftBoundary(root.left);
        printLeaves(root.left);       // left subtree leaves only
        printLeaves(root.right);      // right subtree leaves only
        printRightBoundary(root.right);
        return listBoundary;
    }
    void printLeftBoundary(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        listBoundary.add(root.value);
        if (root.left != null) {
            printLeftBoundary(root.left);
        } else{
            printLeftBoundary(root.right);
        }
    }
    void printLeaves(TreeNode root) {
        if (root == null) return;
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            listBoundary.add(root.value);
        }
        printLeaves(root.right);
    }
    void printRightBoundary(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right != null){
            printRightBoundary(root.right);
        }else{
            printRightBoundary(root.left);
        }
        listBoundary.add(root.value);
    }

//https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(TreeNode root, int x, int y) {
        return level(root,x,1) == level(root,y,1) && (!isSibling(root,x,y));
    }
    public int level(TreeNode root , int target , int lvl){
        if(root == null)return -1;
        if(root.value == target)return lvl;
        int l =level(root.left,target,lvl+1) ;
        if(l != -1){
            return l;
        }
        return level(root.right,target,lvl+1);
    }
    public boolean isSibling(TreeNode root , int x , int y){
        if(root == null)return false;
        if(root.left != null && root.right != null){
            if(root.left.value == x && root.right.value == y){
                return true;
            }
            if(root.left.value == y && root.right.value == x){
                return true;
            }
        }
        return isSibling(root.left,x,y) || isSibling(root.right,x,y);
    }

//https://leetcode.com/problems/most-frequent-subtree-sum/?envType=problem-list-v2&envId=tree
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        HashMap<Integer,Integer > map = new HashMap<>();
        int [] max = {0};

        helperFreq(root,map,max);

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max[0]) {
                list.add(entry.getKey());
            }
        }

        int l = list.size();
        int[] arr = new int[l];
        for(int i = 0 ; i < l ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public int helperFreq(TreeNode root,HashMap<Integer,Integer > map ,int [] max){
        if(root == null)return 0;

        int a = helperFreq(root.left,map,max);
        int b = helperFreq(root.right,map,max);
        int sum = root.value + a + b;

        int freq = map.getOrDefault(sum,0)+1;

        map.put(sum,freq);

        if(freq > max[0]) max[0] = freq;
        return sum;
    }

}