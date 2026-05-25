class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int cnt=0;
        int i=n-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        for(int j=i;j>=0;j--){
            if(s.charAt(j)==' ') break;
            cnt++;
        }
        return cnt;
    }
}