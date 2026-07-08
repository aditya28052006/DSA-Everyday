class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Store non-zero digits and their positions
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        // Prefix sum of digits
        long[] prefixSum = new long[m + 1];

        // Prefix concatenated number
        long[] prefixNum = new long[m + 1];

        // Powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
            prefixNum[i + 1] = (prefixNum[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        // first[i] = first non-zero digit index >= i
        int[] first = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < m && pos.get(idx) < i)
                idx++;
            first[i] = idx;
        }

        // last[i] = last non-zero digit index <= i
        int[] last = new int[n];
        idx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (idx >= 0 && pos.get(idx) > i)
                idx--;
            last[i] = idx;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {

            int l = first[queries[k][0]];
            int r = last[queries[k][1]];

            if (l > r) {
                ans[k] = 0;
                continue;
            }

            int len = r - l + 1;

            long number = (prefixNum[r + 1]
                    - prefixNum[l] * pow10[len]) % MOD;

            if (number < 0)
                number += MOD;

            long sum = prefixSum[r + 1] - prefixSum[l];

            ans[k] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}