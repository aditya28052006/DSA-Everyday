class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=0;
        int high=0;
        for(int candy:candies){
            high=Math.max(candy,high);
        }
        while(low < high){
            int mid=low+(high-low+1)/2;
            long children=0;
            for(int candy:candies){
                children+=candy/mid;
            }
            if(children<k){
                high=mid-1;
            }
            else{
                low=mid;
            }
        }
        return low;
    }
}