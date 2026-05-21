class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(mpp.containsKey(comp)) return new int[]{mpp.get(comp),i};
            mpp.put(nums[i],i);
        }
        return new int[]{};
    }
}