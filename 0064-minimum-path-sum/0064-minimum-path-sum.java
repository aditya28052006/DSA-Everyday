class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans=helper(grid,m-1,n-1,dp);
        return dp[m-1][n-1];
    }

    public int helper(int[][] arr,int i,int j,int dp[][]){
        if(i==0 && j==0) return dp[i][j]=arr[0][0];
        if(i<0 || j<0) return dp[i][j]=(int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;
        if(i>0) up=helper(arr,i-1,j,dp);
        if(j>0) left=helper(arr,i,j-1,dp);
        return dp[i][j]=arr[i][j]+Math.min(up,left);
    }
}