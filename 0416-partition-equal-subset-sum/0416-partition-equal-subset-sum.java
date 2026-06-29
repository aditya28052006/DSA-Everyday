class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;

        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // If the sum is odd, partition into equal subsets is impossible
        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        // prev[sum] indicates if a subset with 'sum' is possible so far
        boolean[] prev = new boolean[target + 1];
        prev[0] = true; // sum = 0 is always possible

        // Initialize with the first element
        if (arr[0] <= target)
            prev[arr[0]] = true;

        // Iterate over all remaining elements
        for (int i = 1; i < n; i++) {
            // cur[sum] will store possibilities for current element
            boolean[] cur = new boolean[target + 1];
            cur[0] = true; // sum 0 always possible

            for (int sum = 1; sum <= target; sum++) {
                // Option 1: Do not take current element
                boolean notTaken = prev[sum];

                // Option 2: Take current element if it fits
                boolean taken = false;
                if (arr[i] <= sum)
                    taken = prev[sum - arr[i]];

                // Current sum possible if either option is true
                cur[sum] = notTaken || taken;
            }

            // Move to the next element
            prev = cur;
        }

        // Final answer is whether target sum is possible
        return prev[target];
    }
}