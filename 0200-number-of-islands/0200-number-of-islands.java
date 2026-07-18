class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(int r,int c,int [][]vis,char [][]grid){
        vis[r][c]=1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int nrow = i + dr[k];
                int ncol = j + dc[k];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == '1') {

                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }

        }

    }
}