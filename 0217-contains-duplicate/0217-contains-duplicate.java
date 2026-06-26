class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Boolean> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(nums[i])){
                return true;
            }
            else{
                mpp.put(nums[i],false);
            }
            
        }
        return false;
    }
}