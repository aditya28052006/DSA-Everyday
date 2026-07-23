class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int count = 0;
        int ans[]=new int[numCourses];

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[count++]=node;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0)
                    q.offer(adjNode);
            }
        }
        if(count!=numCourses){
            return new int[0];
        }
        return ans;

    }
}