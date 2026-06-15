class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(1,k,n,new ArrayList<>(),ans);
        return ans;
    }

    public void solve(int i,int k,int n,List<Integer> list ,List<List<Integer>> ans){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>9) return ;
        if(n<0 || k<0) return;
        
        list.add(i);
        solve(i+1,k-1,n-i,list,ans);
        list.remove(list.size()-1);
        solve(i+1,k,n,list,ans);
        
    }
}