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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        boolean leftOrRight=true;
        while(!q.isEmpty()){
            int n=q.size();
            Integer level[]=new Integer[n];
            for(int i=0;i<n;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);

                int ind=leftOrRight?i:n-1-i;
                level[ind]=q.poll().val;
            }
            leftOrRight=!leftOrRight;
            result.add(Arrays.asList(level));
        }
        return result;
    }
}