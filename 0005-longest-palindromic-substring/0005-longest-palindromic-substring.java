class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int mL=0;
        for(int i=0;i<s.length();i++){
            // odd length
            int l1=expand(s,i,i);
            // even length
            int l2=expand(s,i,i+1);
            int l=Math.max(l1,l2);
            if(l>mL){
                mL=l;
                start=i-(l-1)/2;
            }
        }
        return s.substring(start,start+mL);
    }
    private static int expand(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}