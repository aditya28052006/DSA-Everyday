class Solution {

    private HashMap<Character,String> getMap(){
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }
    

    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return ans;
        HashMap<Character,String> map=getMap();

        solve(0,"",ans,map,digits);
        return ans;

    }

    private void solve(int i,String str,List<String> ans, HashMap<Character,String> map,String digits){
        if(i==digits.length()){
            ans.add(str);
            return;
        }
        String letters=map.get(digits.charAt(i));
        for(int j=0;j<letters.length();j++){
            solve(i+1,str+letters.charAt(j),ans,map,digits);
        }
    }
    
}