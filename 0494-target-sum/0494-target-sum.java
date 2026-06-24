class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        // Step 2: check feasibility
        if ((total + target) % 2 != 0 || Math.abs(target) > total) return 0;

        // Step 3: new target for subset sum problem
        int newTarget = (total + target) / 2;

        // Step 4: initialize dp array of size newTarget + 1 with 0
        int[] dp = new int[newTarget + 1];

        // Step 5: base case: one way to form sum 0 (by choosing nothing)
        dp[0] = 1;

        // Step 6: iterate over each number
        for (int num : nums) {
            // Step 7: update dp array from right to left
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // Step 8: final answer
        return dp[newTarget];
    }
}