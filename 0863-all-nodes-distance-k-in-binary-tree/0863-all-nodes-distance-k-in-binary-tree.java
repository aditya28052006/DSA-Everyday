/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode,TreeNode> track=new HashMap<>();
        markParents(root,track,target);

        Map<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int lvl=0;
        while(!q.isEmpty()){
            int s=q.size();
            if(lvl==k) break;
            lvl++;
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(track.get(curr)!=null && visited.get(track.get(curr))==null){
                    q.offer(track.get(curr));
                    visited.put(track.get(curr),true);
                }

            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            ans.add(curr.val);
        }
        return ans;
    }

    private void markParents(TreeNode root, Map<TreeNode,TreeNode> track, TreeNode target){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                track.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                track.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
}