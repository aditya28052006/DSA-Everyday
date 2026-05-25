class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x<2 && x>0) return 1;
        int h=x;
        int l=1;
        int mid=0;
        int ans=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(mid==x/mid) return mid;
            if(mid<(x/mid)){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        return ans;
    }
}