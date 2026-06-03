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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;
    }
    public TreeNode buildTree(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer> mpp){
        if(ps>pe || is>ie) return null;
        TreeNode root=new TreeNode(preorder[ps]);

        int inroot=mpp.get(root.val);
        int left=inroot-is;
        root.left=buildTree(preorder,ps+1,ps+left,inorder,is,inroot-1,mpp);
        root.right=buildTree(preorder,ps+left+1,pe,inorder,inroot+1,ie,mpp);

        return root;
    }
}