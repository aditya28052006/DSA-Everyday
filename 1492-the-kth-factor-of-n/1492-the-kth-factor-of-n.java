class Solution {
    public int kthFactor(int n, int k) {
        int[] large = new int[(int) Math.sqrt(n) + 1];
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
                if (i != n / i) {
                    large[count++] = n / i;
                }
            }
        }
        for (int i = count - 1; i >= 0; i--) {
            k--;
            if (k == 0) {
                return large[i];
            }
        }
        return -1;
    }
}