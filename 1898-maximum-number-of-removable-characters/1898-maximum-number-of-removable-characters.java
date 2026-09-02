class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {

        int left = 0;
        int right = removable.length;

        while (left < right) {

            int mid = left + (right - left + 1) / 2;

            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean check(String s, String p, int[] removable, int k) {

        boolean[] removed = new boolean[s.length()];

        // Mark first k characters as removed
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0;

        // Check whether p is still a subsequence
        for (int i = 0; i < s.length(); i++) {

            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;

                if (j == p.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}