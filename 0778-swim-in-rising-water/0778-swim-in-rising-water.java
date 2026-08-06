class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] vis=new boolean[n][n];
        q.offer(new int[]{grid[0][0],0,0});

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[1];
            int c=curr[2];
            int cost=curr[0];

            if(vis[r][c]==true) continue;
            vis[r][c]=true;
            if(r==n-1&&c==n-1) return cost;

            for(int d[]:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc]){
                    int newCost=Math.max(grid[nr][nc],cost);
                    q.offer(new int[]{newCost,nr,nc});
                }
            }
        }
        return -1;
    }
}