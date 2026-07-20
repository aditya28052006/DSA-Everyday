class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int cnt=0;
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        
        int t=0;
        // First and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]){
                dfs(i, 0, grid, vis);
                
            }
            if (grid[i][m - 1] == 1 && !vis[i][m - 1])
            {
                dfs(i, m - 1, grid, vis);
                
            }              
        }

        // First and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]){
                dfs(0, j, grid, vis);
                
            }
            if (grid[n - 1][j] ==1 && !vis[n - 1][j]){
                dfs(n - 1, j, grid, vis);
                
            }        
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    t++;
                }
            }
        }
        return t-cnt;
    }
    private void dfs(int row, int col, int[][] grid, boolean[][] vis) {

        vis[row][col] = true;
        cnt++;

        int n = grid.length;
        int m = grid[0].length;

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                grid[nr][nc] == 1) {

                dfs(nr, nc, grid, vis);
                
            }
        }
    }
}