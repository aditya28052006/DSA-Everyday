class Solution {

    public int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        //find the maximum:
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    
    public int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0;
        //find total hours:
        for (int i = 0; i < piles.length; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalH;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        //apply binary search:
        while (low <= high) {
            int mid = low+(high-low) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}