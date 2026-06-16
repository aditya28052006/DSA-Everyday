class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int preSum=0,cnt=0;
        mpp.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int rem=preSum-k;
            cnt+=mpp.getOrDefault(rem,0);
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}