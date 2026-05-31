class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == x) foundX = true;
                if (curr.val == y) foundY = true;

                if (curr.left != null && curr.right != null) {
                    int l = curr.left.val;
                    int r = curr.right.val;

                    if ((l == x && r == y) || (l == y && r == x)) {
                        return false; 
                    }
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }
}