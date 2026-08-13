class Solution {
    static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {

        // Count primes
        boolean[] prime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {

            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        // count! for prime numbers
        long primeWays = 1;

        for (int i = 2; i <= count; i++) {
            primeWays = (primeWays * i) % MOD;
        }

        // (n-count)! for non-prime numbers
        long nonPrimeWays = 1;

        for (int i = 2; i <= n - count; i++) {
            nonPrimeWays = (nonPrimeWays * i) % MOD;
        }

        return (int)((primeWays * nonPrimeWays) % MOD);
    }
}