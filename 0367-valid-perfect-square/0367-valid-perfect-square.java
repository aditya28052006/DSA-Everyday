class Solution {
    public boolean isPerfectSquare(int x) {
        if(x==0) return true;
        if(x==1) return true;
        int h=x;
        int l=1;
        int mid=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(mid==x/mid && x%mid==0) return true;
            if(mid<(x/mid)){
                l=mid+1;
            }
            else h=mid-1;
        }
        return false;
    }
}