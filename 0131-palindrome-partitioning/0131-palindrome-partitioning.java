class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();
        partition(0,s,path,ans);
        return ans;
    }

    private void partition(int index,String s,List<String> path,List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                partition(i+1,s,path,ans);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}