class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans=atMost(nums,goal)-atMost(nums,goal-1);
        return ans;
    }

    public int atMost(int nums[], int k){
        if(k<0) return 0;
        int l=0,r=0,s=0,cnt=0;
        while(r<nums.length){
            s+=nums[r];
            while(s>k){
                s-=nums[l];
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}