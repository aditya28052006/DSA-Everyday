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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair<TreeNode,Integer>> q =new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().getValue();
            int f=0,l=0;
            for(int i=0;i<size;i++){
                int curr_id=q.peek().getValue()-min;
                TreeNode node=q.peek().getKey();
                q.poll();

                if(i==0) f=curr_id;
                if(i==size-1) l=curr_id;
                if(node.left!=null) q.offer(new Pair(node.left,curr_id*2+1));
                if(node.right!=null) q.offer(new Pair(node.right,curr_id*2+2));

            }
            ans=Math.max(ans,l-f+1);
        }
        return ans;
    }
}