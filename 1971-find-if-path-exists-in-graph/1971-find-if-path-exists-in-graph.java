class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];

        return dfs(source, destination, graph, vis);
    }

    boolean dfs(int node, int dest, ArrayList<Integer>[] graph, boolean[] vis) {
        if (node == dest)
            return true;

        vis[node] = true;

        for (int next : graph[node]) {
            if (!vis[next] && dfs(next, dest, graph, vis))
                return true;
        }

        return false;
    }
}