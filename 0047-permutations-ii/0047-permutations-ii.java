class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,ans);
        return ans;
    }

    private void helper(int idx,int[] nums , List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            swap(nums,i,idx);
            helper(idx+1,nums,ans);
            swap(nums,i,idx);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}