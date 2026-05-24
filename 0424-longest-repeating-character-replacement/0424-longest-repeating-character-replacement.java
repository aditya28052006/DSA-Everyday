class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,mL=0,mf=0;
        int freq[]=new int[26];

        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            mf=Math.max(mf,freq[s.charAt(r)-'A']);

            if(((r-l+1)-mf)>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            if(((r-l+1)-mf)<=k){
                mL=Math.max(mL,(r-l+1));
            }
            r++;
        }
        System.gc();
        return mL;
    }
}