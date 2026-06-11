class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        findSubset(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    private void findSubset(int idx,int[] arr,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            findSubset(i+1,arr,list,ans);
            list.remove(list.size()-1);
        }
    }
}