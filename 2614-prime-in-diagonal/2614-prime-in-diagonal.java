class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Main diagonal
            if (isPrime(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }

            // Secondary diagonal
            if (isPrime(nums[i][n - i - 1])) {
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }

        return ans;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}