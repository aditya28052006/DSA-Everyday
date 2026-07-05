class Solution {
    public int myAtoi(String s) {
         int i = 0;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        // Handle sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        return helper(s, i, 0, sign);
    }
    private int helper(String s, int i, long num, int sign) {
        // Stop if non-digit or end of string
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int) (num * sign);
        }

        num = num * 10 + (s.charAt(i) - '0');

        // Overflow check
        if (sign == 1 && num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (sign == -1 && -num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return helper(s, i + 1, num, sign);
    }
}