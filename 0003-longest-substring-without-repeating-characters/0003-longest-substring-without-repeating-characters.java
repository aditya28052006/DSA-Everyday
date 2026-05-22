class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        for(int i=0;i<256;i++){
            hash[i]=-1;
        }
        int l=0,r=0,maxLen=0;
        
        while(r<s.length()){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }
            
            int len=r-l+1;
            maxLen=Math.max(len,maxLen);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxLen;
    }
}