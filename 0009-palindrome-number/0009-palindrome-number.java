class Solution {
    public boolean isPalindrome(int x) {
        if(x<9 && x>=0) return true;
        if(x==10) return false;
        int i=0;
        String str=String.valueOf(x);
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}