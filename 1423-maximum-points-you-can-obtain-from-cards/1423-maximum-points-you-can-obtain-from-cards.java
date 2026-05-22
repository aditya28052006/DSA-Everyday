class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int maxSum=sum;
        int right=cardPoints.length-1;
        for(int left=k-1;left>=0;left--){
            sum-=cardPoints[left];
            sum+=cardPoints[right];
            right--;
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}