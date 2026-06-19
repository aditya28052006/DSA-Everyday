class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int prev[]=new int[n];

        for(int i=0;i<m;i++){
            int temp[]=new int[n];
            for(int j=0;j<n;j++){
                // Base condition 
                if(i==0 && j==0) temp[0]=grid[0][0];
                else{
                    int up=(int)1e9;
                    int left=(int)1e9;
                    if(i>0) up=prev[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=grid[i][j]+Math.min(up,left);
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }

// !!...Memoization...!!


    // public int helper(int[][] arr,int i,int j,int dp[][]){
    //     if(i==0 && j==0) return dp[i][j]=arr[0][0];
    //     if(i<0 || j<0) return dp[i][j]=(int)1e9;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up=Integer.MAX_VALUE;
    //     int left=Integer.MAX_VALUE;
    //     if(i>0) up=helper(arr,i-1,j,dp);
    //     if(j>0) left=helper(arr,i,j-1,dp);
    //     return dp[i][j]=arr[i][j]+Math.min(up,left);
    // }
}