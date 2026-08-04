class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.offer(nei);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {

            int roundTrip = 2 * dist[i];

            int lastReply;

            if (patience[i] >= roundTrip) {
                lastReply = roundTrip;
            } else {
                int lastSend = ((roundTrip - 1) / patience[i]) * patience[i];
                lastReply = lastSend + roundTrip;
            }

            ans = Math.max(ans, lastReply);
        }
         return ans + 1;
    }
}