import java.util.*;
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int effort[][]=new int[n][m];
        for(int[] row:effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        effort[0][0]=0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int currEff=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==n-1 && c==m-1) return currEff;

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newEff=Math.max(currEff,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newEff<effort[nr][nc]){
                        effort[nr][nc]=newEff;
                        pq.offer(new int[]{newEff,nr,nc});
                    }
                }
                
            }
        }
        return 0;
    }
}