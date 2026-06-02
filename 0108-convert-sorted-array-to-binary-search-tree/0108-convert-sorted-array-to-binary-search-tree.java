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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int left,int right){
        if(left>right) return null;
        int m=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[m]);

        root.left=build(nums,left,m-1);
        root.right=build(nums,m+1,right);
        return root;
    }
}