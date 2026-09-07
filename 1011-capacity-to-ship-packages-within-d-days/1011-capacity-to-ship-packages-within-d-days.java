class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;
        for(int w:weights){
            l=Math.max(l,w);
            r+=w;
        }
        while(l<r){
            int m=l+(r-l)/2;
            if(canShip(weights,days,m)){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }
    public static boolean canShip(int[] weights,int days,int m){
        int d=1;
        int load=0;
        for(int w:weights){
            if(load+w>m){
                d++;
                load=0;
            }
            load+=w;
        }
        return d<=days;
    }
}