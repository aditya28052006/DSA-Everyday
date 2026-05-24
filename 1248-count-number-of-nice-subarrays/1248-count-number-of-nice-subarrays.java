class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }

    public int atMost(int[] arr,int k){
        if(k<0) return 0;
        int l=0,r=0,s=0,cnt=0;
        while(r<arr.length){
            s+=(arr[r]%2);
            while(s>k){
                s-=(arr[l]%2);
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}