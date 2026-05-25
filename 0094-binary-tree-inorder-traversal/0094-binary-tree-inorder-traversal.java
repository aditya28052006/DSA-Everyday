/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static void inorder(TreeNode node, List<Integer> arr){
        if(node==null) return;
        inorder(node.left,arr);
        arr.add(node.val);
        inorder(node.right,arr);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return arr;

    }
}