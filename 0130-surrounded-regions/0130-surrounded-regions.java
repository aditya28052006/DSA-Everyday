class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // First and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(i, 0, board, vis);

            if (board[i][m - 1] == 'O' && !vis[i][m - 1])
                dfs(i, m - 1, board, vis);
        }

        // First and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j])
                dfs(0, j, board, vis);

            if (board[n - 1][j] == 'O' && !vis[n - 1][j])
                dfs(n - 1, j, board, vis);
        }

        // Flip surrounded O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] board, boolean[][] vis) {

        vis[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                board[nr][nc] == 'O') {

                dfs(nr, nc, board, vis);
            }
        }
    }
}