class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(1,n,k,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int i, int n,int k,List<Integer> list,List<List<Integer>> ans){
        if(k==0){
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int j=i;j<=n;j++){
            list.add(j);
            helper(j+1,n,k-1,list,ans);
            list.remove(list.size()-1);
        }
    }
}