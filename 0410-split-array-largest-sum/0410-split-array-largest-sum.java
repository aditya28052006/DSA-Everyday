class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }

        // binary search on answer
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;   // try smaller max sum
            } else {
                low = mid + 1; // need larger max sum
            }
        }
        return low;
    }

    // greedy check
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int pieces = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                pieces++;
                currentSum = num;
                if (pieces > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}