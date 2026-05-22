class Solution {
    public int maxSubArray(int[] arr) {
        long max=Long.MIN_VALUE;
        int sum=0;
        int start=0;
        int ansStart=-1;int ansEnd=-1;
        for(int i=0;i<arr.length;i++){
            if(sum==0) start=i;
            sum+=arr[i];
            if(sum>max){
                max=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        return (int)max;
    }
}