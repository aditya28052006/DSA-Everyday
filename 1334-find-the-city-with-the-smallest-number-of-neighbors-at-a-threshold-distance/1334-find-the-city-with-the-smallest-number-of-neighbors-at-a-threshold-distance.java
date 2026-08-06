class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int)1e9;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
        int ans = -1;
        int minReachable = Integer.MAX_VALUE;
         for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= minReachable) {
                minReachable = count;
                ans = i;
            }
        }

        return ans;


    }
}