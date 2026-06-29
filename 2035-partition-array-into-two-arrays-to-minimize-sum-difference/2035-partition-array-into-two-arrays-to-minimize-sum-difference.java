import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        generate(left, leftSums);
        generate(right, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int total = 0;
        for (int num : nums) total += num;

        int ans = Integer.MAX_VALUE;

        for (int leftCount = 0; leftCount <= n; leftCount++) {

            int rightCount = n - leftCount;

            List<Integer> L = leftSums[leftCount];
            List<Integer> R = rightSums[rightCount];

            for (int leftSum : L) {

                int target = total / 2 - leftSum;

                int idx = Collections.binarySearch(R, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < R.size()) {
                    int sum = leftSum + R.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    int sum = leftSum + R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    private void generate(int[] arr, List<Integer>[] sums) {

        int m = arr.length;

        for (int mask = 0; mask < (1 << m); mask++) {

            int sum = 0;
            int count = 0;

            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }

            sums[count].add(sum);
        }
    }
}