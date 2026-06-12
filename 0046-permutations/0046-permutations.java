class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recurr(0,nums,ans);
        return ans;
    }

    private void recurr(int idx,int[] nums,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            recurr(idx+1,nums,ans);
            swap(nums,i,idx); //backtrack
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}