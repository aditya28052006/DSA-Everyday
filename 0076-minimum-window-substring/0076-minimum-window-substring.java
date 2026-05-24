class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int freq[]=new int[256];
        int cnt=0,r=0,l=0,sI=-1,mL=Integer.MAX_VALUE;
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        while(r<s.length()){
            char ch=s.charAt(r);
            if(freq[ch]>0){
                cnt++;
            }
            freq[ch]--;
            while(cnt==t.length()){
                if(r-l+1<mL){
                    mL=r-l+1;
                    sI=l;
                }
                char left=s.charAt(l);
                freq[left]++;
                if(freq[left]>0) cnt--;
                l++;
            }
            r++;
        }
        return sI==-1?"": s.substring(sI,sI+mL);
    }
}