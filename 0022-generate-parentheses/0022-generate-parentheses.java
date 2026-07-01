class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        create("",0,0,n,list);
        return list;
    }
    static void create(String curr, int open,int close, int n, List<String> list){
        if(curr.length()==n*2){
            list.add(curr);
            return;
        }
        if(open<n){
            create(curr+"(",open+1,close,n,list);
        }
        if(close<open){
            create(curr+")",open,close+1,n,list);
        }
    }
}